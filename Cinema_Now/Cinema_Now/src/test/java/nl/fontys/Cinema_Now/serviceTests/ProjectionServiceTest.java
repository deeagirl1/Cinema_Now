package nl.fontys.Cinema_Now.serviceTests;

import nl.fontys.Cinema_Now.converters.ProjectionConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IProjectionDAL;
import nl.fontys.Cinema_Now.dto.ProjectionDTO;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.service.ProjectionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
public class ProjectionServiceTest {


    @Mock
    private IProjectionDAL projectionDAL;

    private ProjectionService service;
    @BeforeEach
    public void setUp()
    {
        service = new ProjectionService(projectionDAL,new ProjectionConverter());

        List<Projection> projections = List.of(
                new Projection("1","15:00","25/05/2021"),
                new Projection("2","14:00","26/05/2021"),
                new Projection("3","12:00","27/05/2021"),
                new Projection("","11:00","28/05/2021")
        );


        when(projectionDAL.getProjectionById("1")).thenReturn(projections.get(0));
        when(projectionDAL.deleteProjection("1")).thenReturn(true);
        when(projectionDAL.getAllProjections()).thenReturn(projections);
        when(projectionDAL.createProjection(projections.get(0))).thenReturn(true);
    }

    @Test
    public void getAllProjectionsTest()
    {
        //act
        List<ProjectionDTO> projections = service.getAllProjections();

        //assert
        Assertions.assertEquals("1", projections.get(0).getId());
        Assertions.assertEquals("2", projections.get(1).getId());
        Assertions.assertEquals("3", projections.get(2).getId());
    }
    @Test
    public void getProjectionById()
    {
        //act
        ProjectionDTO projectionToCheck = service.getProjectionById("1");
        //assert
        Assertions.assertEquals("25/05/2021", projectionToCheck.getDate());

    }


    @Test
    public void deleteProjection_returnFalse()
    {
        //act
        List<ProjectionDTO> projections = service.getAllProjections();
        var result = service.deleteProjection(projections.get(3).getId());
        //assert
        Assertions.assertEquals(result,false);
    }

    @Test
    public void deleteProjection_returnTrue()
    {
        //act
        List<ProjectionDTO> projections = service.getAllProjections();
        var result = service.deleteProjection(projections.get(0).getId());
        //assert
        Assertions.assertEquals(result,true);

    }

    @Test
    public void addProjectionTest()
    {
        //arrange
        ProjectionService service = new ProjectionService(projectionDAL,new ProjectionConverter());
        //act
        ProjectionDTO projection = new ProjectionDTO("4","15:00","26/02/2021");
        service.createProjection(projection);

        ArgumentCaptor<Projection> projectionArgumentCaptor = ArgumentCaptor.forClass(Projection.class);
        //verify
        verify(projectionDAL).createProjection(projectionArgumentCaptor.capture());

        Projection captureProjection = projectionArgumentCaptor.getValue();
        //assert
        Assertions.assertEquals(projection.getDate(), captureProjection.getDate());

    }

    @Test
    public void updateProjectionTest()
    {
        ProjectionDTO projectionDTO =  service.getProjectionById("1");

        projectionDTO.setDate("Test");

        service.editProjection(projectionDTO);

        ArgumentCaptor<Projection> projectionArgumentCaptor= ArgumentCaptor.forClass(Projection.class);

        verify(projectionDAL).editProjection(projectionArgumentCaptor.capture());

        Projection captureProjection = projectionArgumentCaptor.getValue();

        Assertions.assertEquals(projectionDTO.getDate(), captureProjection.getDate());

    }

}
