package homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleStreamUtilsTest {
    List<People> people = Arrays.asList(new People("Вася", 16, People.Sex.MAN),
            new People("Елена", 42, People.Sex.WOMAN),
            new People("Иван Иванович", 69, People.Sex.MAN));
    List<People> peopleWithoutMen = List.of(new People("Елена", 42, People.Sex.WOMAN));

    @Test
    void shouldGetLiableForMilitaryServiceWomen () {
        assertThat(PeopleStreamUtils.findLiableForMilitaryServiceWomen(people))
                .containsExactly(people.get(1));
    }
    @Test
    void shouldGetAverageMensAge () {
        assertThat(PeopleStreamUtils.getAverageMensAge(people)).isEqualTo(42.5);
    }

    @Test
    void shouldGetZeroWithMenAbsence () {
        assertThat(PeopleStreamUtils.getAverageMensAge(peopleWithoutMen)).isEqualTo(0);
    }
    @Test
    void shouldGetEmployablePeople () {
        assertThat(PeopleStreamUtils.findEmployablePeople(people))
                .containsExactly(people.get(1));
    }


}