import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Person {
    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String toString(){
        return this.name + " " + this.gender + " " + this.maritalStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}

interface Critaria {
    public List<Person> filter(List<Person> people);
}

class CriteriaMale implements Critaria{

    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> res = new ArrayList<>();

        for(Person p: people){
            if(p.getGender().equalsIgnoreCase("male"))
                res.add(p);
        }

        return res;
    }
}

class CriteriaFemale implements Critaria{

    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> res = new ArrayList<>();

        for(Person p: people){
            if(p.getGender().equalsIgnoreCase("female"))
                res.add(p);
        }

        return res;
    }
}

class CriteriaSingle implements Critaria{

    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> res = new ArrayList<>();

        for(Person p: people){
            if(p.getMaritalStatus().equalsIgnoreCase("single"))
                res.add(p);
        }

        return res;
    }
}

class AndCriteria implements Critaria{
    Critaria critariaA;
    Critaria critariaB;

    AndCriteria(Critaria critariaA, Critaria critariaB){
        this.critariaA = critariaA;
        this.critariaB = critariaB;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> critariaAPeople = critariaA.filter(people);
        List<Person> critariaBPeople = critariaB.filter(people);

        List<Person> res = new ArrayList<>();
        Set<Person> critariaBPeopleSet = new HashSet<>(critariaBPeople);

        for(Person p: critariaAPeople){
            if(critariaBPeopleSet.contains(p)){
                res.add(p);
            }
        }

        return res;
    }
}

class OrCriteria implements Critaria{
    Critaria critariaA;
    Critaria critariaB;

    OrCriteria(Critaria critariaA, Critaria critariaB){
        this.critariaA = critariaA;
        this.critariaB = critariaB;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> critariaAPeople = critariaA.filter(people);
        List<Person> critariaBPeople = critariaB.filter(people);
        Set<Person> res = new HashSet<>();

        for(Person p: critariaAPeople){
           res.add(p);
        }

        for(Person p: critariaBPeople){
            res.add(p);
        }

        return new ArrayList<>(res);
    }
}

public class FilterPattern {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Critaria male = new CriteriaMale();
        Critaria female = new CriteriaFemale();
        Critaria single = new CriteriaSingle();
        Critaria singleAndMale = new AndCriteria(male, single);
        Critaria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Single: ");
        System.out.println(single.filter(persons));

        System.out.println("Males: ");
        System.out.println(male.filter(persons));

        System.out.println("\nFemales: ");
        System.out.println(female.filter(persons));

        System.out.println("\nSingle And Males: ");
        System.out.println(singleAndMale.filter(persons));

        System.out.println("\nSingle Or Females: ");
        System.out.println(singleOrFemale.filter(persons));


    }
}
