package A20210415.E2;

import A20210415.E1.LectorDeFicheroSeparadoPorDosPuntos;

import java.util.List;
import java.util.stream.Collectors;

public class SaveItAsObjects {
    private static void printMinorsOf(Integer age, List<A20210415.E2.Persona> list) {
        System.out.println("Minors of " + age + ":\n" + list.stream().filter(persona -> persona.getAge()<age&&persona.getAge()>=0).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        LectorDeFicheroSeparadoPorDosPuntos E2 = new LectorDeFicheroSeparadoPorDosPuntos();
        E2.extractFileData(true);

        System.out.println("---------------");
        // System.out.println(A20210415.E2.getPeopleList().toString());

        printMinorsOf(15, E2.getPeopleList());
    }


}
