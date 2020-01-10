package spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(PrizeRepo prizeRepo, GameRepo gameRepo, StateRepo stateRepo) {
        return (args) -> {
            Game powerball = new Game("Powerball");
            Game megaMillions = new Game("Mega Millions");
            Game gopher5 = new Game("Gopher 5");

            List<State> stateList = generateStates();
            stateRepo.save(stateList);
            State minn = stateRepo.findOne(23);
            List<State> gopherState = new ArrayList<>();
            gopherState.add(minn);
            gopher5.setStateList(gopherState);
            List<State> states = new ArrayList<>(stateList);
            states.remove(1);
            states.remove(2);
            states.remove(11);
            states.remove(24);
            states.remove(28);
            states.remove(44);
            powerball.setStateList(states);
            megaMillions.setStateList(states);

            gameRepo.save(powerball);
            gameRepo.save(megaMillions);
            gameRepo.save(gopher5);

            List<Prize> prizeList = generatePrizes();
            for (int y=0; y < 9; y++)
                prizeList.get(y).setGame(powerball);
            for (int y=9; y < 18; y++)
                prizeList.get(y).setGame(megaMillions);
            for (int y=18; y <= 21; y++)
                prizeList.get(y).setGame(gopher5);
            prizeRepo.save(prizeList);
            // States that cant have Powerball/Mega Millions
            // Alabama-1, Alaska-2, Hawaii-11, Mississippi-24, Nevada-28, Utah-44
            // Gopher5 is only in MN-23


        };
    }

    private static List<State> generateStates() {
        List<State> stateList = new ArrayList<>();
        stateList.add(new State("Alabama", "AL"));
        stateList.add(new State("Alaska", "AK"));
        stateList.add(new State("Arizona", "AZ"));
        stateList.add(new State("Arkansas", "AR"));
        stateList.add(new State("California", "CA"));
        stateList.add(new State("Colorado", "CO"));
        stateList.add(new State("Connecticut", "CT"));
        stateList.add(new State("Delaware", "DE"));
        stateList.add(new State("Florida", "FL"));
        stateList.add(new State("Georgia", "GA"));
        stateList.add(new State("Hawaii", "HI"));
        stateList.add(new State("Idaho", "ID"));
        stateList.add(new State("Illinois", "IL"));
        stateList.add(new State("Indiana", "IN"));
        stateList.add(new State("Iowa", "IA"));
        stateList.add(new State("Kansas", "KS"));
        stateList.add(new State("Kentucky", "KY"));
        stateList.add(new State("Louisiana", "LA"));
        stateList.add(new State("Maine", "ME"));
        stateList.add(new State("Maryland", "MD"));
        stateList.add(new State("Massachusetts", "MA"));
        stateList.add(new State("Michigan", "MI"));
        stateList.add(new State("Minnesota", "MN"));
        stateList.add(new State("Mississippi", "MS"));
        stateList.add(new State("Missouri", "MO"));
        stateList.add(new State("Montana", "MT"));
        stateList.add(new State("Nebraska", "NE"));
        stateList.add(new State("Nevada", "NV"));
        stateList.add(new State("New Hampshire", "NH"));
        stateList.add(new State("New Jersey", "NJ"));
        stateList.add(new State("New Mexico", "NM"));
        stateList.add(new State("New York", "NY"));
        stateList.add(new State("North Carolina", "NC"));
        stateList.add(new State("North Dakota", "ND"));
        stateList.add(new State("Ohio", "OH"));
        stateList.add(new State("Oklahoma", "OK"));
        stateList.add(new State("Oregon", "OR"));
        stateList.add(new State("Pennsylvania", "PA"));
        stateList.add(new State("Rhode Island", "RI"));
        stateList.add(new State("South Carolina", "SC"));
        stateList.add(new State("South Dakota", "SD"));
        stateList.add(new State("Tennessee", "TN"));
        stateList.add(new State("Texas", "TX"));
        stateList.add(new State("Utah", "UT"));
        stateList.add(new State("Vermont", "VT"));
        stateList.add(new State("Virginia", "VA"));
        stateList.add(new State("Washington", "WA"));
        stateList.add(new State("West Virginia", "WV"));
        stateList.add(new State("Wisconsin", "WI"));
        stateList.add(new State("Wyoming", "WY"));
        return stateList;
    }

    private static List<Prize> generatePrizes() {
        List<Prize> prizeList = new ArrayList<>();
        prizeList.add(new Prize("Powerball Only", "$4", "1 in 38"));
        prizeList.add(new Prize("1 of 5 + Powerball", "$4", "1 in 92"));
        prizeList.add(new Prize("2 of 5 + Powerball", "$7", "1 in 701"));
        prizeList.add(new Prize("3 of 5", "$7", "1 in 580"));
        prizeList.add(new Prize("3 of 5 + Powerball", "$100", "1 in 14,494"));
        prizeList.add(new Prize("4 of 5", "$100", "1 in 36,525"));
        prizeList.add(new Prize("4 of 5 + Powerball", "$50,000", "1 in 913,129"));
        prizeList.add(new Prize("5 of 5", "$1,000,000", "1 in 11,688,054"));
        prizeList.add(new Prize("5 of 5 + Powerball", "JACKPOT", "1 in 292,201,338"));

        prizeList.add(new Prize("Mega Ball Only", "$2", "1 in 37"));
        prizeList.add(new Prize("1 of 5 + Mega Ball", "$4", "1 in 89"));
        prizeList.add(new Prize("2 of 5 + Mega Ball", "$10", "1 in 693"));
        prizeList.add(new Prize("3 of 5", "$10", "1 in 606"));
        prizeList.add(new Prize("3 of 5 + Mega Ball", "$200", "1 in 14,547"));
        prizeList.add(new Prize("4 of 5", "$500", "1 in 38,792"));
        prizeList.add(new Prize("4 of 5 + Mega Ball", "$10,000", "1 in 931,001"));
        prizeList.add(new Prize("5 of 5", "$1,000,000", "1 in 12,607,306"));
        prizeList.add(new Prize("5 of 5 + Mega Ball", "JACKPOT", "1 in 302,575,350"));

        prizeList.add(new Prize("2 of 5", "$1", "1 in 13"));
        prizeList.add(new Prize("3 of 5", "$15", "1 in 178"));
        prizeList.add(new Prize("4 of 5", "$500", "1 in 7,304"));
        prizeList.add(new Prize("5 of 5", "JACKPOT", "1 in 1,533,939"));
        return prizeList;
    }

}

//    private static void LessonJPAManyToMany(MovieRepository movieRepository, ProductionCompanyRepository productionCompanyRepository){
//        movieRepository.save(new Movie("Batman"));
//        movieRepository.save(new Movie("The Shining"));
//        movieRepository.save(new Movie("The Lighthouse"));
//
//        productionCompanyRepository.save(new ProductionCompany("Warner Bros."));
//        productionCompanyRepository.save(new ProductionCompany("Paramount"));
//        productionCompanyRepository.save(new ProductionCompany("20th Century Fox"));
//
//        Movie m1 = movieRepository.findOne(1);
//
//        List<ProductionCompany> pcList = new ArrayList<>();
//        pcList.add(productionCompanyRepository.findOne(1));
//        pcList.add(productionCompanyRepository.findOne(2));
//
//        m1.setProductionCompanyList(pcList);
//        movieRepository.save(m1);
//
//        Movie movieRetrieve = movieRepository.findOne(1);
//        log.info("MOVIE TITLE: " + movieRetrieve.getMovieTitle());
//        for(ProductionCompany pc : movieRetrieve.getProductionCompanyList()){
//            log.info("PROD COMP: " + pc.getProductionCompanyName());
//        }
//
//        ProductionCompany pc1 = productionCompanyRepository.findOne(1);
//
//        List<Movie> mList = new ArrayList<>();
//        mList.add(movieRepository.findOne(1));
//        mList.add(movieRepository.findOne(2));
//        mList.add(movieRepository.findOne(3));
//        pc1.setMovieList(mList);
//        productionCompanyRepository.save(pc1);
//    }
//
//    private static void LessonJPAOneToMany(PersonRepository personRepository, EmailRepository emailRepository) {
//
////            Email email = new Email("bipin@bipin.com");
////            email.setPerson(bipinPerson);
////            emailRepository.save(email);
//
//        Person bipinPerson = new Person("Bipin");
//        List<Email> emailList = new ArrayList<>();
//        emailList.add(new Email("bipin@gmail.com"));
//        emailList.add(new Email("bipin@hotmail.com"));
//        emailList.add(new Email("bipin@yahoo.com"));
//
//
//        bipinPerson.setEmailList(emailList);
////            emailRepository.save(emailList);
//        personRepository.save(bipinPerson);
//    }
//
//    private static void LessonJPAIntro (PersonRepository personRepository) {
//        log.info("----------------It's Working----------------");
//        personRepository.save(new Person("Bipin"));
//        personRepository.save(new Person("Dan"));
//        personRepository.save(new Person("Sean"));
//
//        Person person = new Person();
//        person.setFirstName("Java");
//        person.setMiddleName("Persistence API");
//        person.setLastName("IS AWESOME!!");
//        person.setSSN("222-11-9999");
//
//        personRepository.save(person);
//
//        for(int x = 0; x < 10; x++){
//            Person pers = new Person("Person" + x);
//            pers.setLastName("LastName" + x);
//            pers.setSSN("111-" + x + x);
//            personRepository.save(pers);
//        }
//        List<Person> personListToSave = new ArrayList<Person>();
//        for(int x = 0; x < 10; x++){
//            Person pers = new Person("PersonL" + x);
//            pers.setLastName("LastNameL" + x);
//            pers.setSSN("LLL-" + x + x);
//            personListToSave.add(pers);
//        }
//        personRepository.save(personListToSave);
//
//        Person foundPerson = personRepository.findOne(20);
//        log.info("Person Found:" + foundPerson.getFirstName() + " " + foundPerson.getLastName());
//
//        for(Person p : personRepository.findAll()){
//            log.info("Person Found: " + p.getId() + " " + p.getFirstName() + " " + p.getLastName());
//        }
//        if(personRepository.exists(4))
//            personRepository.delete(4);
//        else
//            log.info("No Person with this Id exists");
//
//        log.info("Person with ID 4 exists: " + personRepository.exists(4));
//        log.info("Person with ID 4 exists: " + personRepository.exists(44));
//        log.info("Total Person Records: " + personRepository.count());
//
////            personRepository.deleteAll();
//    }
