package nl.fontys.Cinema_Now.serviceTests;

import nl.fontys.Cinema_Now.converters.ComplaintConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IComplaintDAL;
import nl.fontys.Cinema_Now.dalInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.dto.ComplaintDTO;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Complaint;
import nl.fontys.Cinema_Now.service.ComplaintService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class ComplaintServiceMockTest {

    @Mock
    private IComplaintDAL complaintDAL;
    @Mock
    private IUserDAL userDAL;

    private ComplaintConverter converter;

    private ComplaintService service;
    @BeforeEach
    public void setUp()
    {
        service = new ComplaintService(complaintDAL,userDAL,new ComplaintConverter());

        List<AppUser> appUsers = List.of(
                new AppUser("1","Andreea","Sindrilaru","deeagirl1@gmail.com","Boschdijk 42-E",20),
                new AppUser("2","Iris","Johnson","i.johnson@gmail.com","Passtor 42-E",30),
                new AppUser("3","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40)

        );
        List<Complaint> complaints = List.of(
                new Complaint("1","test","test","26/06/2021",appUsers.get(0)),
                new Complaint("2","test","test","26/06/2021",appUsers.get(1)),
                new Complaint("3","test","test","26/06/2021",appUsers.get(2))
        );


          when(complaintDAL.getAllComplaints()).thenReturn(complaints);
          when(complaintDAL.getComplaintByUser(appUsers.get(0))).thenReturn(complaints.get(0));
          when(complaintDAL.getComplaint("1")).thenReturn(complaints.get(0));

          when(userDAL.getUserByID("1")).thenReturn(appUsers.get(0));

    }

    @Test
    public void getAllComplaintsTest_ReturnList()
    {
        //act
        List<ComplaintDTO> complaints = service.getAllComplaints();

        //assert
        Assertions.assertEquals("test", complaints.get(0).getTitle());
    }

    @Test
    public void getComplaintByUser_ReturnComplaint()
    {
        //act
        AppUser user = userDAL.getUserByID("1");
        ComplaintDTO complaint = service.getComplaintByUser(user);

        //assert
        Assertions.assertEquals("test", complaint.getTitle());
    }

    @Test
    public void getComplaintByUser_ReturnNull()
    {
        //act
        AppUser user = userDAL.getUserByID("5");
        ComplaintDTO complaint = service.getComplaintByUser(user);

        //assert
        Assertions.assertEquals(null, complaint);
    }

    @Test
    public void getComplaintById_IdNotBlank()
    {
        //act
        ComplaintDTO complaint = service.getComplaint("1");

        //assert
        Assertions.assertEquals("test", complaint.getTitle());
    }

    @Test
    public void getComplaintById_IdBlank()
    {
        //act
        ComplaintDTO complaint = service.getComplaint("");

        //assert
        Assertions.assertEquals(null, complaint);
    }

    @Test
    public void createComplaintTest()
    {
        //act
        AppUser user = userDAL.getUserByID("1");
        ComplaintDTO complaintDTO = new ComplaintDTO("1","test",user.getId(),"Sindrilaru","25/02/2021");
        service.createComplaint(complaintDTO);

        ArgumentCaptor<Complaint> complaintArgumentCaptor = ArgumentCaptor.forClass(Complaint.class);

        verify(complaintDAL).createComplaint(complaintArgumentCaptor.capture());

        Complaint captureComplaint = complaintArgumentCaptor.getValue();

        Assertions.assertEquals(complaintDTO.getTitle(), captureComplaint.getTitle());

    }

}
