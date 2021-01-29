/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.item;

import beans.ItemStock;
import dao.SessionFactoryBuilder;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Terance Wijesuriya
 */
public class ItemDAOImpl implements ItemDAOInterface {

    private final SessionFactoryBuilder sessionFactoryBuilder = SessionFactoryBuilder.getInstance();

    @Override
    public List<ItemStock> getAllItemStocks(Session session) {
        Query query = session.createQuery("FROM ItemStock i");
        List<ItemStock> list = (List<ItemStock>) query.list();
        return list;
    }

    @Override
    public List<ItemStock> getItemsByCategory(int idCategory, Session session) {
        Query query = session.createQuery("FROM ItemStock i where i.category.idcategory =:categoryId");
        query.setParameter("categoryId", idCategory);
        List<ItemStock> list = (List<ItemStock>) query.list();
        return list;
    }

    @Override
    public List<ItemStock> getWarrantyItems(int warrantyStatus, Session session) {
        if (warrantyStatus == 1) {
            Query query = session.createQuery("FROM ItemStock i where i.warranty =:status");
            query.setParameter("status", true);
            List<ItemStock> list = (List<ItemStock>) query.list();
            return list;
        } else {
            List<ItemStock> list = new ArrayList<>();
            return list;
        }
    }

    @Override
    public List<ItemStock> getItemsByCategoryAndPrice(int idCatgeory, double startPrice, double endPrice, Session session) {
        if (startPrice > 0 && endPrice > 0) {
            BigDecimal startb = new BigDecimal(startPrice, MathContext.DECIMAL64);
            BigDecimal endb = new BigDecimal(endPrice, MathContext.DECIMAL64);
            Query query = session.createQuery("FROM ItemStock i where i.category.idcategory =:categoryId AND i.sellingPrice BETWEEN :startPrice AND :endPrice");
            query.setParameter("categoryId", idCatgeory);
            query.setParameter("startPrice", startb);
            query.setParameter("endPrice", endb);
            List<ItemStock> list = (List<ItemStock>) query.list();
            return list;
        } else {
            List<ItemStock> list = new ArrayList<>();
            return list;
        }
    }

    @Override
    public List<ItemStock> getDeliverableItems(int deliveryStatus, Session session) {
        if (deliveryStatus == 1) {
            Query query = session.createQuery("FROM ItemStock i where i.delivery =:status");
            query.setParameter("status", true);
            List<ItemStock> list = (List<ItemStock>) query.list();
            return list;
        } else {
            List<ItemStock> list = new ArrayList<>();
            return list;
        }
    }

    @Override
    public List<ItemStock> getItemsForCustomizations(int idCategory, int warrantyStatus, int deliveryStatus, Session session) {
        StringBuilder builder = new StringBuilder();
        builder.append("FROM ItemStock i where i.category.idcategory =:categoryId");
        if (warrantyStatus == 1) {
            builder.append(" AND i.warranty = true ");
        }

        if (deliveryStatus == 1) {
            builder.append(" AND i.delivery = true ");
        }

        String sqlQuery = builder.toString();
        Query query = session.createQuery(sqlQuery);
        query.setParameter("categoryId", idCategory);
        List<ItemStock> list = (List<ItemStock>) query.list();
        return list;
    }

    @Override
    public Session openCurrentSession() {
        return sessionFactoryBuilder.getSessionFactory().openSession();
    }

    @Override
    public Transaction openTransaction(Session session) {
        Transaction transaction = session.beginTransaction();
        return transaction;
    }

}
