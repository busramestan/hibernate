package com.busra.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Bu sınıf Hibernate ile veritabanına bağlanmak için gerekli olan
 * SessionFactory nesnesini oluşturur ve yönetir.
 * Proje boyunca sadece 1 kez oluşturulur ve herkes onu kullanır.
 */
public class HibernateUtil {

    // Uygulama boyunca bir kere oluşturulacak olan SessionFactory nesnesi
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * SessionFactory'yi oluşturur.
     * hibernate.cfg.xml dosyasını okur ve gerekli bağlantı ayarlarını yapar.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Hibernate konfigürasyon dosyasını ("hibernate.cfg.xml") okur
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Hata olursa ekrana yazar ve uygulamayı durdurur
            System.err.println("SessionFactory oluşturulurken hata oluştu: " + ex);
            throw new ExceptionInInitializerError(ex); // Hata fırlatılır
        }
    }

    /**
     * SessionFactory'yi dışarıdan almak için bu metot kullanılır.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Uygulama kapandığında kaynakları serbest bırakmak için çağrılır.
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
}
