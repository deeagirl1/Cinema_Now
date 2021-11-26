package nl.fontys.Cinema_Now.ServiceTests;

import nl.fontys.Cinema_Now.Converter.ComplaintConverter;
import nl.fontys.Cinema_Now.Converter.UserConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IComplaintDAL;
import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.Service.ComplaintService;
import nl.fontys.Cinema_Now.Service.UserService;
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
    private IUserDAL userDAL;
    private ComplaintConverter converter;


    @BeforeEach
    public void setUp()
    {
        List<AppUser> appUsers = List.of(
                new AppUser("1","Andreea","Sindrilaru","deeagirl1@gmail.com","Boschdijk 42-E",20),
                new AppUser("2","Iris","Johnson","i.johnson@gmail.com","Passtor 42-E",30),
                new AppUser("3","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40)

        );
        List<Complaint> complaints = List.of(
                new Complaint("1","test","test","26/06/2021"),
                new Complaint("2","test","test","26/06/2021")
        );


          when(complaintDAL.getAllComplaint()).thenReturn(complaints);
          when(userDAL.getUserByID("1")).thenReturn(appUsers.get(0));
    }

//    @Test
//    public void getAllComplaintsTest()
//    {
//        //arrange
//        ComplaintService service = new ComplaintService(complaintDAL,userDAL,converter);
//        //act
//        List<Complaint> complaints = converter.dtoToEntity(service.getAllComplaint());
//
//        //assert
//        Assertions.assertEquals("test", complaints.get(0).getTitle());
//    }

//    @Test
//    public void createComplaintTest()
//    {
//        //arrange
//        ComplaintService service = new ComplaintService(complaintDAL,userDAL,new ComplaintConverter());
//        //act
//        UserDTO user = new UserDTO("1","deeagirl1@gmail.com","Andreea","Sindrilaru","123", "m.zavaroanu@gmail.com");
//        ComplaintDTO complaintDTO = new ComplaintDTO("deeagirl1@gmail.com","Andreea","Sindrilaru",user.getId());
//        service.createComplaint(complaintDTO);
//
//        ArgumentCaptor<Complaint> complaintArgumentCaptor = ArgumentCaptor.forClass(Complaint.class);
//        ArgumentCaptor<AppUser> appUserArgumentCaptor = ArgumentCaptor.forClass(AppUser.class);
//
//        verify(complaintDAL).createComplaint(complaintArgumentCaptor.capture());
//        verify(userDAL).getUserByID(appUserArgumentCaptor.capture().getId());
//
//        Complaint captureComplaint = complaintArgumentCaptor.getValue();
//        AppUser captureAppUser = appUserArgumentCaptor.getValue();
//
//        Assertions.assertEquals(complaintDTO.getTitle(), captureComplaint.getTitle());
//        Assertions.assertEquals(complaintDTO.getSender(), captureAppUser.getId());
//
//    }

}
