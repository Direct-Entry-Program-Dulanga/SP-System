package Service;

import Model.Payment;
import Service.exception.DuplicateEntryException;
import Service.exception.NotFoundException;
import redis.clients.jedis.Jedis;
import util.JedisClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PaymentServiceRedis {
    private static final String DB_PREFIX = "P#";
    private final Jedis client;

    public PaymentServiceRedis() {
        client = JedisClient.getInstance().getClient();
    }

    public void savePayment(Payment payment) throws DuplicateEntryException {

        if (client.exists( payment.getCid())) {
            throw new DuplicateEntryException();
        }
        client.hset(payment.getCid(), payment.toMap());
    }

    public void updatePayment(Payment payment) throws NotFoundException {

        if (!client.exists(payment.getCid())) {
            throw new NotFoundException();
        }
        client.hset(payment.getCid(), payment.toMap());
    }

    public void deletePayment(String cid) throws NotFoundException {
        if (!client.exists(cid)) {
            throw new NotFoundException();
        }
        client.del(cid);
    }

    private boolean exitsPayment(String cid) {
        return client.exists(cid);
    }

    public Payment findPayment(String cid) throws NotFoundException {
        if (!client.exists(cid)) {
            throw new NotFoundException();
        }
        return Payment.fromMap(cid, client.hgetAll(cid));
    }

    public List<Payment> findAllPayments() {
        List<Payment> paymentList = new ArrayList<>();
        Set<String> cidList = client.keys("*");

        for (String cid : cidList) {
            paymentList.add(Payment.fromMap(cid, client.hgetAll(cid)));
        }
        return paymentList;
    }

    public List<Payment> findPayments(String query) {
        List<Payment> searchResult = new ArrayList<>();
        Set<String> cidList = client.keys("*");

        for (String cid : cidList) {

            if (cid.contains(query)){
                searchResult.add(Payment.fromMap(cid, client.hgetAll(cid)));
            }else{
                List<String> data = client.hvals(cid);

                for (String value : data) {
                    if (value.contains(query)){
                        searchResult.add(Payment.fromMap(cid, client.hgetAll(cid)));
                        break;
                    }
                }
            }
        }

        return searchResult;
    }
}
