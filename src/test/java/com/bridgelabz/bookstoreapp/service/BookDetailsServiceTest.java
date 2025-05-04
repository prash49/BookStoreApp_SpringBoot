package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.BookDetailsRepository;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookDetailsServiceTest {

    @InjectMocks
    BookDetailsService bookDetailsService;

    @Mock
    BookDetailsRepository bookDetailsRepository;

    @Mock
    UserRegistrationRepository userRegistrationRepository;

    @Mock
    TokenUtil tokenUtil;

    @Test
    void addBookTestCaseForSuccess() {
        String dummyToken = "ABCD";
        BookDetailsDto bookDetailsDto = new BookDetailsDto();
        bookDetailsDto.setBookAuthor("Prashanth");
        bookDetailsDto.setBookDescription("Testing");
        bookDetailsDto.setBookLogo("abcd");
        BookDetails bookDetails = new BookDetails();
        bookDetails.createBook(bookDetailsDto);
        Mockito.when(bookDetailsRepository.save(bookDetails)).thenReturn(bookDetails);
        UserRegistrationData userRegistrationData = new UserRegistrationData();
        userRegistrationData.setUserId(1);
        Mockito.when(userRegistrationRepository.findById(1)).thenReturn(Optional.of(userRegistrationData));
        Mockito.when(tokenUtil.decodeToken(dummyToken)).thenReturn(1L);
        Mockito.when(userRegistrationRepository.findById(1)).thenReturn(Optional.of(userRegistrationData));
        BookDetails bookDetailsToCompare = bookDetailsService.addBook(dummyToken, bookDetailsDto);
        //Test if the BookDetails matched

        assertEquals(bookDetails.getBookId(), bookDetailsToCompare.getBookId());
        //we can test proper exceptions also by using assertThrows
        RuntimeException runtimeException =  assertThrows(RuntimeException.class, () -> {
            bookDetailsService.addBook(dummyToken,bookDetailsDto);
        });
        assertEquals("Book not added",runtimeException.getMessage() );
        Mockito.verify(bookDetailsRepository, Mockito.times(0)).save(Mockito.any(BookDetails.class));
    }

    //Unit testing Life cycle
    // we have different phases
    //classlevel setup --> setup  --> test execution --> CleanUp --> class level Cleanup
    //for Above we use diffrent annotations

    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all its a static hence only one printed");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("it'll create for each method class to loan some dynamic data");
    }

    @Test
    public void testExecution(){
        System.out.println("test execution");
    } @Test
    public void testExecution2(){
        System.out.println("test execution 2");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each method if i need to update any dynamic data i'll use this");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("after all test cases ran i need to clean any data then i'll use this");
    }

    // Lets write a test case for delete method and return nothing
//    @Test
    void deleteBookSuccessFullCase(){
        Mockito.doNothing().when(bookDetailsRepository).deleteById(1);
        String dummyToken = "ABCE";
        UserRegistrationData userRegistrationData = new UserRegistrationData();
        userRegistrationData.setUserId(1);
        Mockito.when(userRegistrationRepository.findById(1)).thenReturn(Optional.of(userRegistrationData));
        Mockito.when(tokenUtil.decodeToken(dummyToken)).thenReturn(1L);
        Mockito.when(userRegistrationRepository.findById(1)).thenReturn(Optional.of(userRegistrationData));
        BookDetails bookDetails = new BookDetails();
        bookDetails.setBookId(1);
        Mockito.when(bookDetailsRepository.findByBookId(1)).thenReturn(Optional.of(bookDetails));
        Mockito.when(bookDetailsService.getBookById(dummyToken, 1)).thenReturn(bookDetails);
        bookDetailsService.deleteBook(dummyToken, 1);
        Mockito.verify(bookDetailsRepository , Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testingPrivateMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
      Method invokePrivate = BookDetailsService.class.getDeclaredMethod("printPrivateMethodData", String.class);
       invokePrivate.setAccessible(true);
       invokePrivate.invoke(bookDetailsService,  "book");
    }

}