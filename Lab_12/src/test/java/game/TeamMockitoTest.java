package game;

import org.example.com.education.ztu.game.AgeComparator;
import org.example.com.education.ztu.game.Employee;
import org.example.com.education.ztu.game.Team;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TeamMockitoTest {

    @Mock
    private ArrayList<Employee> mockParticipants;

    @Spy
    private ArrayList<Employee> spyParticipants;

    @InjectMocks
    private Team<Employee> team;

    @Captor
    private ArgumentCaptor<Employee> employeeCaptor;

    @Before
    public void setUp() {
        team = new Team<>("Mock Team");
    }

    @Test
    public void testAddNewParticipant() {
        // Arrange
        Employee mockEmployee = mock(Employee.class);
        when(mockEmployee.getName()).thenReturn("Mock Employee");

        // Act
        team.addNewParticipant(mockEmployee);

        // Assert
        verify(mockEmployee, atLeastOnce()).getName();
    }

    @Test
    public void testSortParticipantsByAgeUsingSpy() {
        // Arrange
        spyParticipants.add(new Employee("Alice", 30));
        spyParticipants.add(new Employee("Bob", 25));
        team.setParticipants(spyParticipants);

        // Act
        team.sortParticipantsByAge();

        // Assert
        assertEquals("Bob", spyParticipants.get(0).getName());
        assertEquals("Alice", spyParticipants.get(1).getName());
        verify(spyParticipants, atLeastOnce()).sort(any(AgeComparator.class));
    }

    @Test
    public void testPlayWithUsingMock() {
        // Arrange
        Team<Employee> mockOpponent = mock(Team.class);
        when(mockOpponent.getName()).thenReturn("Mock Opponent");

        // Act
        team.playWith(mockOpponent);

        // Assert
        verify(mockOpponent, never()).addNewParticipant(any());
    }

    @Test
    public void testAddNewParticipantWithCaptor() {
        // Arrange
        Employee emp = new Employee("Captured Employee", 22);

        // Act
        team.addNewParticipant(emp);

        // Assert
        verify(mockParticipants, atLeastOnce()).add(employeeCaptor.capture());
        assertEquals("Captured Employee", employeeCaptor.getValue().getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayWithNull() {
        // Act & Assert
        team.playWith(null);
    }
}