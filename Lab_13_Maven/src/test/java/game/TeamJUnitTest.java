package game;

import org.example.com.education.ztu.game.Employee;
import org.example.com.education.ztu.game.Team;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.RunWith;
import junitparams.*;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TeamJUnitTest {

    private Team<Employee> team;
    private Team<Employee> opponentTeam;

    @Rule
    public TestName testName = new TestName();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Виконується перед усіма тестами.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Виконується після всіх тестів.");
    }

    @Before
    public void setUp() {
        team = new Team<>("Team A");
        opponentTeam = new Team<>("Team B");
    }

    @After
    public void tearDown() {
        System.out.println("Тест завершено: " + testName.getMethodName());
    }

    @Test
    public void testAddNewParticipant() {
        Employee emp = new Employee("Alice", 30);
        team.addNewParticipant(emp);
        assertTrue(team.getName().contains("Team A"));
    }

    @Test
    public void testPlayWith() {
        team.playWith(opponentTeam);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayWithNull() {
        team.playWith(null);
    }

    @Test
    public void testSortByAge() {
        team.addNewParticipant(new Employee("Alice", 30));
    }

}