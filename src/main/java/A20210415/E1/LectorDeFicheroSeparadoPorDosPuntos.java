package A20210415.E1;

import A20210415.E1.Elements.Age;
import A20210415.E1.Elements.City;
import A20210415.E1.Elements.Name;
import A20210415.E2.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class LectorDeFicheroSeparadoPorDosPuntos {
    private static final String FILE = "src/main/java/A20210415/DataFile.txt";
    private static final String FILLER = "Null";

    private static List<Persona> peopleList = new ArrayList<>();

    public static List<Persona> getPeopleList() {
        return peopleList;
    }

    public static void extractFileData(Boolean isE2) {
        try {
            List<A20210415.E1.DataElement> elementos = new ArrayList<>();

            elementos.add(new Name());
            elementos.add(new City());
            elementos.add(new Age());

            BufferedReader br = new BufferedReader(new FileReader(FILE));

            String line;
            Integer lineNum = 0;
            while ((line = br.readLine()) != null) {
                lineNum++;
                List<String> elements = listAdapter(Arrays.stream(line.split(":")).collect(Collectors.toList()));

                if (!isE2)
                System.out.println(toString(elementos.get(0).extract(elements), elementos.get(1).extract(elements), elementos.get(2).extract(elements), lineNum));

                if (isE2)
                    peopleList.add(new Persona(elementos.get(0).extract(elements), elementos.get(1).extract(elements), ageFixer(elementos.get(2).extract(elements))));
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String toString(String name, String city, String age, Integer lineNum) {
        return ("Línea "  + lineNum + ". Nombre: " + name + ". Población: " + city + ". Edad: " + age);
    }

    private static List<String> listAdapter (List<String> list) {
        for (int i = 3 - list.size(); i > 0; i--) {
            list.add(FILLER);
        }

        AtomicReference<Integer> quantum = new AtomicReference(-1);
        list.forEach(element->{
            quantum.getAndSet(quantum.get() + 1);

            if (element.equals(""))
                list.set(quantum.get(), FILLER);
        });

        return list;
    }

    private static Integer ageFixer(String strAge) {
        Integer result = -1;

        if (!strAge.equals(FILLER))
            result = Integer.valueOf(strAge);

        return result;
    }

    public static void main(String[] args) {
        extractFileData(false);
    }
}
