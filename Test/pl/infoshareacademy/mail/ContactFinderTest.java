package pl.infoshareacademy.mail;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.infoshareacademy.mail.mailparser.MailBox;

import java.util.Collections;
import java.util.List;
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

}