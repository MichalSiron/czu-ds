package cz.czu.thesis.ds;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import cz.czu.thesis.ds.model.Address;
//import cz.czu.thesis.ds.model.Name;
import cz.czu.thesis.ds.model.Address;
import cz.czu.thesis.ds.model.Name;
import cz.czu.thesis.ds.model.Person;
import cz.czu.thesis.ds.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DsApplicationTest {

    @Autowired
    private ConfigurableApplicationContext context;

    @Test
    public void contextWired() {
        Assert.assertNotNull(context);
    }

    @Test
    public void isContextRunning() { assertTrue(context.isRunning()); }

    @Test
    public void isContextActive() { assertTrue(context.isActive()); }


//    @Test
//    public void databaseStructureTest() throws JsonProcessingException {
//        Address address = new Address(1L, "Karla stecha", "Ceske Budejovice", 37005);
//        Name name = new Name(1L, "Michal", "Siron");
//        Person person = new Person(1L, name, address);
//        User user = new User(1L, person);
//        user.setUsername("sironm");
//        user.setPassword("12345");
//
//        name.setPerson(person);
//        address.setPerson(person);
//        person.setUser(user);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        System.out.println(objectMapper.writeValueAsString(user));
//    }


//    @Test
//    public void whenCreatesEmptyOptional_thenCorrect() {
//        Optional<String> empty = Optional.empty();
//        assertFalse(empty.isPresent());
//    }
//
//    @Test
//    public void givenNonNull_whenCreatesOptional_thenCorrect() {
//        String name = "baeldung";
//        Optional<String> opt = Optional.of(name);
//        assertEquals("Optional[baeldung]", opt.toString());
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
//        String name = null;
//        Optional<String> opt = Optional.of(name);
//    }
//
//    @Test
//    public void givenNonNull_whenCreatesNullable_thenCorrect() {
//        String name = "baeldung";
//        Optional<String> opt = Optional.ofNullable(name);
//        assertEquals("Optional[baeldung]", opt.toString());
//    }
//
//    @Test
//    public void givenNull_whenCreatesNullable_thenCorrect() {
//        String name = null;
//        Optional<String> opt = Optional.ofNullable(name);
//        assertEquals("Optional.empty", opt.toString());
//    }
//
//    @Test
//    public void givenOptional_whenIsPresentWorks_thenCorrect() {
//        Optional<String> opt = Optional.of("Baeldung");
//        assertTrue(opt.isPresent());
//
//        opt = Optional.ofNullable(null);
//        assertFalse(opt.isPresent());
//    }
//
//    @Test
//    public void givenOptional_whenIfPresentWorks_thenCorrect() {
//        Optional<String> opt = Optional.of("baeldung");
//
//        opt.ifPresent(name -> System.out.println(name.length()));
//    }
//
//    @Test
//    public void whenOrElseWorks_thenCorrect() {
//        String nullName = null;
//        String name = Optional.ofNullable(nullName).orElse("john");
//        assertEquals("john", name);
//    }
//
//    @Test
//    public void whenOrElseGetWorks_thenCorrect() {
//        String nullName = null;
//        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
//        assertEquals("john", name);
//    }
//
//    class Modem {
//        private Double price;
//
//        public Modem(Double price) {
//            this.price = price;
//        }
//
//        public Double getPrice() {
//            return price;
//        }
//    }
//
//    public boolean priceIsInRange2(Modem modem2) {
//        return Optional.ofNullable(modem2)
//                .map(Modem::getPrice)
//                .filter(p -> p >= 10)
//                .filter(p -> p <= 15)
//                .isPresent();
//    }
//
//    @Test
//    public void whenFiltersWithOptional_thenCorrect() {
//        assertTrue(priceIsInRange2(new Modem(10.0)));
//        assertFalse(priceIsInRange2(new Modem(9.9)));
//        assertFalse(priceIsInRange2(new Modem(null)));
//        assertFalse(priceIsInRange2(new Modem(15.5)));
//        assertFalse(priceIsInRange2(null));
//    }
//
//    @Test
//    public void givenOptional_whenMapWorks_thenCorrect() {
//        List<String> companyNames = Arrays.asList(
//                "paypal", "oracle", "", "microsoft", "", "apple");
//        Optional<List<String>> listOptional = Optional.of(companyNames);
//
//        int size = listOptional
//                .map(List::size)
//                .orElse(0);
//        assertEquals(6, size);
//    }
//
//    @Test
//    public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
//        String password = " password ";
//        Optional<String> passOpt = Optional.of(password);
//        boolean correctPassword = passOpt.filter(
//                pass -> pass.equals("password")).isPresent();
//        assertFalse(correctPassword);
//
//        correctPassword = passOpt
//                .map(String::trim)
//                .filter(pass -> pass.equals("password"))
//                .isPresent();
//        assertTrue(correctPassword);
//    }
//
//    class Person {
//        private String name;
//        private int age;
//        private String password;
//
//        public Person(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public Optional<String> getName() {
//            return Optional.ofNullable(name);
//        }
//
//        public Optional<Integer> getAge() {
//            return Optional.ofNullable(age);
//        }
//
//        public Optional<String> getPassword() {
//            return Optional.ofNullable(password);
//        }
//    }
//
//    @Test
//    public void givenOptional_whenFlatMapWorks_thenCorrect2() {
//        Person person = new Person("john", 26);
//        Optional<Person> personOptional = Optional.of(person);
//
//        Optional<Optional<String>> nameOptionalWrapper
//                = personOptional.map(Person::getName);
//        Optional<String> nameOptional
//                = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
//        String name1 = nameOptional.orElse("");
//        assertEquals("john", name1);
//
//        String name = personOptional
//                .flatMap(Person::getName)
//                .orElse("");
//        assertEquals("john", name);
//    }


}
