/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package eac5;

import eac5.gestors.GestorEscultura;
import eac5.gestors.GestorException;
import eac5.gestors.GestorFotografia;
import eac5.gestors.GestorMuseu;
import eac5.gestors.GestorObra;
import eac5.gestors.GestorPintura;
import eac5.model.Escultura;
import eac5.model.Fotografia;
import eac5.model.Museu;
import eac5.model.Obra;
import eac5.model.Pintura;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author joan
 */
@SpringBootTest(classes={eac5.MainClass.class})
@TestMethodOrder(OrderAnnotation.class)
public class TestGestors {

  
    @Autowired
    private GestorMuseu gestorMuseu;
    
    @Autowired
    private GestorObra gestorObra;
    
    @Autowired
    private GestorPintura gestorPintura;
    
    @Autowired 
    private GestorEscultura gestorEscultura;
    
    @Autowired
    private GestorFotografia gestorFotografia;    

    private static List<Museu> llistaMuseus;
    private static List<Obra> llistaObres;



   
    public void inicialitzaDades() throws GestorException {
        netejaBD();

        llistaMuseus = creaLlistaMuseus();
        llistaObres = creaLlistaObres();
        
        for(Museu m:llistaMuseus){
            gestorMuseu.inserir(m);
        }
        
        for(Obra o:llistaObres){
            gestorObra.inserir(o);
        }
        
        // A memòria: afegir a cada museu les seves obres
        for(Obra o:llistaObres){
            llistaMuseus.get(o.getMuseu().getId()-1).getObres().add(o);
        }        

    }

    private void netejaBD()  throws GestorException{
        
        List<Museu> llistaMuseus= gestorMuseu.consultaMuseus();
        List<Obra> llistaObres = gestorObra.consultaObres();
        
        for (Obra obra : llistaObres) {
            gestorObra.eliminar(obra.getId());
        }
        
        for (Museu museu : llistaMuseus) {
            gestorMuseu.eliminar(museu.getId());
        }

    }

    private List<Museu> creaLlistaMuseus() {

        return List.of(
                new Museu(1, "Museu del Louvre", "París"),
                new Museu(2, "Museu d'Art Modern (MoMA)", "Nova York"),
                new Museu(3, "Museu del Prado", "Madrid"),
                new Museu(4, "Museu Reina Sofia", "Madrid"),
                new Museu(5, "British Museum", "Londres"),
                new Museu(6, "Galeria de l'Acadèmia", "Florència")
        );
    }

    private List<Obra> creaLlistaObres() {
        return List.of(
                new Pintura(1, "Mona Lisa", "Leonardo da Vinci", 100_000_000, LocalDate.of(2019, 5, 15),
                        "Bon estat", LocalDate.of(2023, 10, 20), 77, 53, llistaMuseus.get(0), "Oli", "Taula de roure"),
                new Pintura(2, "La nit estrellada", "Vincent van Gogh", 80_000_000, LocalDate.of(2018, 8, 28),
                        "Bon estat", LocalDate.of(2022, 9, 10), 73.7, 92.1, llistaMuseus.get(1), "Oli", "Tela de lli"),
                new Pintura(3, "Les menines", "Diego Velázquez", 90_000_000, LocalDate.of(2020, 3, 12),
                        "Bon estat", LocalDate.of(2023, 12, 5), 318, 276, llistaMuseus.get(2), "Oli", "Tela de cànem"),
                new Pintura(4, "El naixement de Venus", "Sandro Botticelli", 110_000_000, LocalDate.of(2017, 11, 20),
                        "Bon estat", LocalDate.of(2021, 10, 15), 172.5, 278.5, llistaMuseus.get(5), "Témpera", "Tela de lli"),
                new Pintura(5, "Guernica", "Pablo Picasso", 120_000_000, LocalDate.of(2016, 6, 5),
                        "Bon estat", LocalDate.of(2020, 9, 25), 776, 349, llistaMuseus.get(2), "Oli", "Tela de lli"),
                new Escultura(6, "David", "Michelangelo", 200_000_000, LocalDate.of(2017, 6, 10),
                        "Bon estat", LocalDate.of(2022, 11, 30), 1700, 5170, llistaMuseus.get(5), 1200, "Marbre", "Pedestal de pedra", 5500),
                new Escultura(7, "El pensador", "Auguste Rodin", 150_000_000, LocalDate.of(2016, 9, 25),
                        "Bon estat", LocalDate.of(2021, 8, 12), 80, 110, llistaMuseus.get(0), 110, "Bronze", "Pedestal de granit", 250),
                new Escultura(8, "La Pietà", "Michelangelo", 180_000_000, LocalDate.of(2018, 2, 15),
                        "Bon estat", LocalDate.of(2022, 5, 20), 195, 174, llistaMuseus.get(5), 120, "Marbre", "Pedestal de marbre", 5700),
                new Escultura(9, "El discobol", "Mirón de Eleuteras", 160_000_000, LocalDate.of(2019, 7, 30),
                        "Bon estat", LocalDate.of(2023, 11, 5), 80, 150, llistaMuseus.get(4), 50, "Bronze", "Pedestal de granit", 1200),
                new Escultura(10, "El Baco ebri", "Michelangelo", 170_000_000, LocalDate.of(2020, 4, 12),
                        "Bon estat", LocalDate.of(2024, 2, 28), 52, 154, llistaMuseus.get(5), 55, "Marbre", "Pedestal de marbre", 1540),
                new Fotografia(11, "Claustre de Sant Cugat del Vallès", "Franck y Wigle", 3_000_000, LocalDate.of(2020, 11, 3),
                        "Bon estat", LocalDate.of(2024, 1, 5), 16.4, 20.3, llistaMuseus.get(2), false),
                new Fotografia(12, "Arc de Constantí al fòrum", "Giacomo Caneva", 1_300_000, LocalDate.of(2016, 10, 1),
                        "Bon estat", LocalDate.of(2024, 1, 5), 16.4, 20.3, llistaMuseus.get(2), false),
                new Fotografia(13, "Migrant Mother", "Dorothea Lange", 4_000_000, LocalDate.of(2017, 5, 25),
                        "Bon estat", LocalDate.of(2021, 12, 30), 28.3, 21.8, llistaMuseus.get(1), false),
                new Fotografia(14, "A River of King Penguins Sitting on Their Eggs on Île de la Possession", "Bruno Zehnder", 19_000, LocalDate.of(2016, 9, 15),
                        "Bon estat", LocalDate.of(2020, 11, 10), 34.2, 51.2, llistaMuseus.get(1), true)
        );

    }


    @BeforeEach
    public void setUp() throws GestorException {
        inicialitzaDades();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    @Order(1)
    public void testAfegirMuseusAmbObres() throws GestorException {
        inicialitzaDades();

        assertThrows(GestorException.class, () -> {
            gestorMuseu.inserir(llistaMuseus.get(0));
        });
        
        assertThrows(GestorException.class, () -> {
            gestorObra.inserir(llistaObres.get(0));
        });

    }

    @ParameterizedTest
    @ValueSource(strings = {"Barcelona", "Girona", "Tarragona", "Lleida", "Reus", "Manresa", "Terrassa"})
    @Order(2)
    public void testConsultaMuseus(String ciutat) {

        List<Museu> result = gestorMuseu.consultaMuseus(ciutat);


        List<Museu> expResult = llistaMuseus.stream().sorted(Comparator.comparingInt(Museu::getId)).filter(e -> e.getCiutat().equals(ciutat)).toList();
        result.sort(Comparator.comparingInt(Museu::getId));

        assertEquals(expResult, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @Order(3)
    void testConsultaObres(int idMuseu) throws GestorException {


        List<Obra> result = gestorObra.consultaObres(idMuseu);
        List<Obra> expResult = llistaMuseus.get(idMuseu - 1).getObres();
        result.sort(Comparator.comparingInt(Obra::getId));
        expResult.sort(Comparator.comparingInt(Obra::getId));

        assertEquals(expResult, result);

        assertThrows(GestorException.class, () -> {
            gestorObra.consultaObres(16);
        });

    }

    @Test
    @Order(4)
    void testConsultaPintures() {

        List<Pintura> expResult = llistaObres.stream().sorted(Comparator.comparingInt(Obra::getId)).filter(m -> m instanceof Pintura).map(m -> (Pintura) m).toList();
        List<Pintura> result = gestorPintura.consultaPintures();

        result.sort(Comparator.comparingLong(Obra::getId));

        assertEquals(expResult, result);
    }

    @Test
    @Order(5)
    void testConsultaPinturesInterval() {

        List<Pintura> expResult = llistaObres.stream().sorted(Comparator.comparingInt(Obra::getId))
                .filter(m -> m instanceof Pintura).map(m -> (Pintura) m)
                .filter(m -> m.getAmplada() * m.getAlcada() >= 4000 && m.getAmplada() * m.getAlcada() <= 7000).toList();
        List<Pintura> result = gestorPintura.consultaPintures(4000, 7000);

        result.sort(Comparator.comparingLong(Obra::getId));

        assertEquals(expResult, result);
    }

    @Test
    @Order(6)
    void testConsultaFotografies() {

        List<Fotografia> expResult = llistaObres.stream().sorted(Comparator.comparingInt(Obra::getId))
                .filter(m -> m instanceof Fotografia).map(m -> (Fotografia) m)
                .toList();
        List<Fotografia> result = gestorFotografia.consultaFotografies();

        result.sort(Comparator.comparingInt(Obra::getId));

        assertEquals(expResult, result);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @Order(7)
    void testConsultaFotografies(boolean color) {

        List<Fotografia> expResult = llistaObres.stream().sorted(Comparator.comparingLong(Obra::getId))
                .filter(m -> m instanceof Fotografia)
                .map(m -> (Fotografia) m)
                .filter(m -> m.isColor() == color)
                .toList();
        List<Fotografia> result = gestorFotografia.consultaFotografies(color);

        result.sort(Comparator.comparingLong(Obra::getId));

        assertEquals(expResult, result);
    }

    @Test
    @Order(8)
    void testConsultaEscultures() {

        List<Escultura> expResult = llistaObres.stream().sorted(Comparator.comparingInt(Obra::getId))
                .filter(m -> m instanceof Escultura)
                .map(m -> (Escultura) m)
                .toList();
        List<Escultura> result = gestorEscultura.consultaEscultures();

        result.sort(Comparator.comparingInt(Obra::getId));

        assertEquals(expResult, result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {100, 500, 1000, 2000, 5000, 10000})
    @Order(9)
    void testConsultaEscultures(double pes) {

        List<Escultura> expResult = llistaObres.stream().sorted(Comparator.comparingInt(Obra::getId))
                .filter(m -> m instanceof Escultura)
                .map(m -> (Escultura) m).filter(m -> m.getPes() >= pes).toList();
        
        List<Escultura> result = gestorEscultura.consultaEscultures(pes);

        result.sort(Comparator.comparingLong(Obra::getId));

        assertEquals(expResult, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
    @Order(10)
    void testActualitzaDataRestauracio(int idObra) throws GestorException {

        gestorObra.actualitzaDataRestauracio(idObra, LocalDate.now());
        List<Obra> result = gestorObra.consultaObres();
        List<Obra> expResult = llistaObres;

        expResult.get(idObra - 1).setDataRestauracio(LocalDate.now());
        expResult.get(idObra - 1).setEstat("Perfecte");

        result.sort(Comparator.comparingInt(Obra::getId));

        assertEquals(expResult, result);
        assertThrows(GestorException.class, () -> {
            gestorObra.actualitzaDataRestauracio(20, LocalDate.now());
        });

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @Order(11)
    void testActualitzarDataRevisio(int idMuseu) throws GestorException {

        gestorMuseu.actualitzaDataRevisio(idMuseu, LocalDate.now());
        List<Obra> result = gestorObra.consultaObres();
        List<Obra> expResult = llistaObres;

        Museu museu = llistaMuseus.get(idMuseu - 1);
        for (Obra obra : museu.getObres()) {
            obra.setDataRevisio(LocalDate.now());
        }

        result.sort(Comparator.comparingInt(Obra::getId));

        assertEquals(expResult, result);

        assertThrows(GestorException.class, () -> {
            gestorMuseu.actualitzaDataRevisio(20, LocalDate.now());
        });

    }

    @Test
    @Order(12)
    void testConvertirCmAm() {


        llistaObres = llistaObres.stream()
                .map(m -> {
                    m.setAlcada(m.getAlcada() / 100.0);
                    m.setAmplada(m.getAmplada() / 100.0);
                    if (m instanceof Escultura) {
                        Escultura escultura = (Escultura) m;
                        escultura.setProfunditat(escultura.getProfunditat() / 100.0);
                        return escultura;
                    } else {
                        return m;
                    }
                }).toList();

        List<Obra> expResult = llistaObres;
        gestorObra.convertirCmAm();
        List<Obra> result = gestorObra.consultaObres();
        result.sort(Comparator.comparingInt(Obra::getId));

        assertEquals(expResult, result);
    }

    @ParameterizedTest
    @CsvSource({
        "Michellangelo,         10",
        "Leonardo da Vinci,     50",
        "Pablo Picasso,         100",})
    @Order(13)
    void testRevalora(String autor, int percentatge) {

        llistaObres = llistaObres.stream()
                .map(m -> {
                    if (m.getAutor().equals(autor)) {
                        m.setValor(m.getValor() * (1 + percentatge / 100.0));
                    }
                    return m;
                }).toList();

        List<Obra> expResult = llistaObres;
        gestorObra.revalora(autor, percentatge);
        List<Obra> result = gestorObra.consultaObres();
        result.sort(Comparator.comparingInt(Obra::getId));

        assertEquals(expResult, result);
    }

    
    @Test
    @Order(14)
    void testEliminarObra() throws GestorException {

        gestorObra.eliminar(10);
        llistaObres = llistaObres.stream().filter(o -> o.getId() != 10).toList();
        
        List<Obra> result = gestorObra.consultaObres();
        result.sort(Comparator.comparingInt(Obra::getId));
        
        assertEquals(llistaObres, result);

        assertThrows(GestorException.class, () -> {
            gestorObra.eliminar(10);
        });
    }

    
    @Test
    @Order(15)
    void eliminarMuseu() throws GestorException {

        gestorMuseu.eliminar(3);
        List<Obra> result = gestorObra.consultaObres();
        result.sort(Comparator.comparingInt(Obra::getId));

        List<Obra> expResult = llistaObres.stream().filter(o -> o.getMuseu().getId() != 3).toList();

        assertEquals(expResult, result);

        assertThrows(GestorException.class, () -> {
            gestorMuseu.eliminar(3);
        });
    }
    
    
    @Test
    @Order(16)
    void testInserirObra() throws GestorException {

        Obra o = new Pintura(26, "La persistencia de la memoria", "Salvador Dalí", 75_000_000, LocalDate.of(2019, 2, 5),
                "Bon estat", LocalDate.of(2024, 1, 15), 24, 33, llistaMuseus.get(3), "Oli", "Llenç");
        llistaMuseus.get(3).getObres().add(o);
        gestorObra.inserir(o);

        assertThrows(GestorException.class, () -> {
            gestorObra.inserir(o);
        });

    }
 
}
