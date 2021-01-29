/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Category;
import beans.ItemStock;
import dao.item.ItemDAOImpl;
import dao.item.ItemDAOInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Terance Wijesuriya
 */
public class ItemService {

    private static ItemDAOInterface itemDAOInterface;

    public ItemService() {
        itemDAOInterface = new ItemDAOImpl();
    }

    public Session getSession() {
        return itemDAOInterface.openCurrentSession();
    }

    public Transaction getTransaction(Session session) {
        return itemDAOInterface.openTransaction(session);
    }

    public List<ItemStock> getAllItemStocks() {
        Session session = getSession();
        Transaction transaction = null;
        List<ItemStock> itemStocks = new ArrayList<>();
        List<ItemStock> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            itemStocks = itemDAOInterface.getAllItemStocks(session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (ItemStock itemStock : itemStocks) {

                Category category = new Category();
                Category cat = itemStock.getCategory();
                category.setIdcategory(cat.getIdcategory());
                category.setCategoryName(cat.getCategoryName());

                itemStock.setCategory(category);
                list.add(itemStock);
            }
        }
        return list;
    }

    public List<ItemStock> getItemsByCategory(int idCategory) {
        Session session = getSession();
        Transaction transaction = null;
        List<ItemStock> itemStocks = new ArrayList<>();
        List<ItemStock> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            itemStocks = itemDAOInterface.getItemsByCategory(idCategory, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (ItemStock itemStock : itemStocks) {

                Category category = new Category();
                Category cat = itemStock.getCategory();
                category.setIdcategory(cat.getIdcategory());
                category.setCategoryName(cat.getCategoryName());

                itemStock.setCategory(category);
                list.add(itemStock);
            }
        }
        return list;
    }

    public List<ItemStock> getWarrantyItems(int warrantyStatus) {
        Session session = getSession();
        Transaction transaction = null;
        List<ItemStock> itemStocks = new ArrayList<>();
        List<ItemStock> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            itemStocks = itemDAOInterface.getWarrantyItems(warrantyStatus, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (ItemStock itemStock : itemStocks) {

                Category category = new Category();
                Category cat = itemStock.getCategory();
                category.setIdcategory(cat.getIdcategory());
                category.setCategoryName(cat.getCategoryName());

                itemStock.setCategory(category);
                list.add(itemStock);
            }
        }
        return list;
    }

    public List<ItemStock> getItemsByCategoryAndPrice(int idCatgeory, double startPrice, double endPrice) {
        Session session = getSession();
        Transaction transaction = null;
        List<ItemStock> itemStocks = new ArrayList<>();
        List<ItemStock> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            itemStocks = itemDAOInterface.getItemsByCategoryAndPrice(idCatgeory, startPrice, endPrice, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (ItemStock itemStock : itemStocks) {

                Category category = new Category();
                Category cat = itemStock.getCategory();
                category.setIdcategory(cat.getIdcategory());
                category.setCategoryName(cat.getCategoryName());

                itemStock.setCategory(category);
                list.add(itemStock);
            }
        }
        return list;
    }

    public List<ItemStock> getDeliverableItems(int deliveryStatus) {
        Session session = getSession();
        Transaction transaction = null;
        List<ItemStock> itemStocks = new ArrayList<>();
        List<ItemStock> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            itemStocks = itemDAOInterface.getDeliverableItems(deliveryStatus, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (ItemStock itemStock : itemStocks) {

                Category category = new Category();
                Category cat = itemStock.getCategory();
                category.setIdcategory(cat.getIdcategory());
                category.setCategoryName(cat.getCategoryName());

                itemStock.setCategory(category);
                list.add(itemStock);
            }
        }
        return list;
    }

    public List<ItemStock> getItemsForCustomizations(int idCategory, int warrantyStatus, int deliveryStatus) {
        Session session = getSession();
        Transaction transaction = null;
        List<ItemStock> itemStocks = new ArrayList<>();
        List<ItemStock> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            itemStocks = itemDAOInterface.getItemsForCustomizations(idCategory, warrantyStatus, deliveryStatus, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (ItemStock itemStock : itemStocks) {

                Category category = new Category();
                Category cat = itemStock.getCategory();
                category.setIdcategory(cat.getIdcategory());
                category.setCategoryName(cat.getCategoryName());

                itemStock.setCategory(category);
                list.add(itemStock);
            }
        }
        return list;
    }
}
