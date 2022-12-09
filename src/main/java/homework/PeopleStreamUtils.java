package homework;

import java.util.List;

public class PeopleStreamUtils {

    public static List<People> findLiableForMilitaryServiceWomen(List<People> people) {
        return people.stream().filter(x -> x.getSex().equals(People.Sex.WOMAN))
                .filter(x -> x.getAge() > 18 && x.getAge() < 60).toList();
    }

    public static List<People> findEmployablePeople(List<People> people) {
        return people.stream()
                .filter(x -> {
                    boolean isEmployable;
                    if (x.getSex().equals(People.Sex.MAN)) {
                        isEmployable = x.getAge() > 18 && x.getAge() < 60;
                    } else {
                        isEmployable = x.getAge() > 18 && x.getAge() < 55;
                    }
                    return isEmployable;
                })
                .toList();
    }

    public static double getAverageMensAge(List<People> people) {
        try {
            return people.stream().filter(x -> x.getSex().equals(People.Sex.MAN))
                    .mapToInt(People::getAge).average().getAsDouble();
        } catch (Exception e) {
            System.out.println("No men in a list");
            return 0;
        }
    }
}
