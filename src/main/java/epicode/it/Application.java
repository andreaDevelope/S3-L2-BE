package epicode.it;

import com.github.javafaker.Faker;
import epicode.it.dao.EventoDAO;
import epicode.it.entity.Evento;
import epicode.it.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Application {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");

        // uso il factory per creare dei gestori entità che sono le classi java che rappresentano le tabelle del db
        // questo gestore ha i metodi che salvano cancellano e recuperano i dati da db
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(new Locale("it"));

        EventoDAO autoreDAO = new EventoDAO(em);
        List<Evento> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Evento e = new Evento();
            e.setTitolo(faker.book().title()); // Titolo casuale
            e.setDataEvento(faker.date().future(30, java.util.concurrent.TimeUnit.DAYS).toInstant()
                    .atZone(java.time.ZoneId.systemDefault()).toLocalDate()); // Data futura casuale
            e.setDescrizione(faker.lorem().sentence()); // Descrizione casuale
            e.setTipoEvento(faker.bool().bool() ? TipoEvento.PUBBLICO : TipoEvento.PRIVATO); // Tipo casuale

            lista.add(e);

        }

        autoreDAO.insertAll(lista);
    }
}
