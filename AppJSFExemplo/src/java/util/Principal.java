/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.HibernateUtil;
import dao.HibernateUtility;
import entidade.Curso;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author marcelo.horvath1
 */
public class Principal {

    public static void main(String[] args) {
        //  adiciona();
        //  altera();
        //adicionaAprimorado();
        alteraAprimorado();
    }

    private static void adiciona() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Curso c1 = new Curso();
        c1.setNome("Tec Web");
        Curso c2 = new Curso();
        c2.setNome("Tec Seg Trab");

        session.getTransaction().begin();
        session.saveOrUpdate(c1);
        session.saveOrUpdate(c2);
        session.getTransaction().commit();

    }

    private static void altera() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Curso> lista = new ArrayList();
        lista = session.createQuery("from Curso").list();
        System.out.println("Qtd retornda: " + lista.size());
        Curso c = lista.get(0);
        System.out.println("Alterndo... " + c.getNome());
        c.setNome("Teste");
        session.getTransaction().begin();
        session.saveOrUpdate(c);
        session.getTransaction().commit();

    }

    private static void adicionaAprimorado() {

        Curso c1 = new Curso();
        c1.setNome("Tec Web");
        Curso c2 = new Curso();
        c2.setNome("Tec Seg Trab");

        HibernateUtility.beginTransaction();
        HibernateUtility.getSession().saveOrUpdate(c2);
        HibernateUtility.getSession().saveOrUpdate(c1);
        HibernateUtility.commitTransaction();
    }

    private static void alteraAprimorado() {
        List<Curso> lista = new ArrayList();
        lista = HibernateUtility.getSession().createQuery("from Curso").list();
        System.out.println("Qtd retornda: " + lista.size());
        Curso c = lista.get(0);
        System.out.println("Alterndo... " + c.getNome());
        c.setNome("Teste");
        HibernateUtility.beginTransaction();
        HibernateUtility.getSession().saveOrUpdate(c);
        HibernateUtility.commitTransaction();
    }
}
