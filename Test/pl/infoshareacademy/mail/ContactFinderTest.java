package pl.infoshareacademy.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.infoshareacademy.mail.mailparser.MailBox;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactFinderTest {

    @Mock
    MailBox mailBox;

    ContactFinder sut = new ContactFinder();

    @Test
    public void shouldNotFindEmailInEmptyMailBox() throws Exception {
        // given
        when(mailBox.getMailbox()).thenReturn(Collections.emptyList());

        // when
        Set<String> foundMails = sut.findMail(mailBox);

        // then
        assertThat(foundMails).isEmpty();
    }

    @Test
    public void shouldFindOneEmailInSingleElementMailboxByMessageText() throws Exception {
        // given
        String testEmail = "tetetestEmail@test.test";
        Email email = mock(Email.class);
        when(email.getMessage()).thenReturn("test email message with email " + testEmail + " email end");
        when(mailBox.getMailbox()).thenReturn(Stream.of(email).collect(Collectors.toList()));

        // when
        Set<String> foundMails = sut.findMail(mailBox);

        // then
        assertThat(foundMails).isNotEmpty();
        assertThat(foundMails).hasSize(1);
        assertThat(foundMails).containsExactly(testEmail);
    }

    @Test
    public void shouldFindOnePhoneNoInSingleElementMailboxByMessageText() throws Exception {
        // given
        String testPhoneNo = "+48600900700";
        Email email = mock(Email.class);
        when(email.getMessage()).thenReturn("test email message with some phone number " + testPhoneNo + " email end");
        when(mailBox.getMailbox()).thenReturn(Stream.of(email).collect(Collectors.toList()));

        // when
        Set<String> foundPhoneNo = sut.findPhoneNo(mailBox);

        // then
        assertThat(foundPhoneNo).isNotEmpty();
        assertThat(foundPhoneNo).hasSize(1);
        assertThat(foundPhoneNo).containsExactly(testPhoneNo);
    }

    @Test
    public void shouldFindOneWebsiteInSingleElementMailboxByMessageText() throws Exception {
        // given
        String testWebsiteAddress = "www.someawesomesite.com/application/";
        Email email = mock(Email.class);
        when(email.getMessage()).thenReturn("test email message with some website adress " +
                                            testWebsiteAddress + " email end");
        when(mailBox.getMailbox()).thenReturn(Stream.of(email).collect(Collectors.toList()));

        // when
        Set<String> foundWebsites = sut.findWebsite(mailBox);

        // then
        assertThat(foundWebsites).isNotEmpty();
        assertThat(foundWebsites).hasSize(1);
        assertThat(foundWebsites).containsExactly(testWebsiteAddress);
    }

    @Test
    public void shouldFindOneMailInSingleElementMailboxByMessageText() throws Exception {
        // given
        String testKeyword = "urgent";
        Email email = mock(Email.class);
        when(email.getMessage()).thenReturn("test email message with some keyword in it " + testKeyword + " email end");
        when(mailBox.getMailbox()).thenReturn(Stream.of(email).collect(Collectors.toList()));
        String searchkeywords = "urgent";

        // when
        Set<String> foundMessagesWithKeyword = sut.findQA(mailBox, searchkeywords);

        // then
        assertThat(foundMessagesWithKeyword).isNotEmpty();
        assertThat(foundMessagesWithKeyword).hasSize(1);
        assertThat(foundMessagesWithKeyword.hashCode()).isEqualTo(email.hashCode());
    }
}