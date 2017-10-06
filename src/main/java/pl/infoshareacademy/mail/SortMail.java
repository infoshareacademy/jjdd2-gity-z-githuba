package pl.infoshareacademy.mail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortMail {

  /*      private SearchCriteria searchCriteria = new SearchCriteria();

        public Set<Email> createUniqueEmailsSet(List<Email> emails) {

            Set<Email> sortedMails = new HashSet<>();
            List<Email> emailsFoundByEmail = new ArrayList<>();
            List<Email> emailsFoundByEmailAndDate = new ArrayList<>();

            String getStartDate = searchCriteria.getStartDate();
            String getEndDate = searchCriteria.getEndDate();
            List<String> getEmail = searchCriteria.getEmail();
            List<String> getKeywords = searchCriteria.getKeywords();

            if (1 == getEmail.size() && "".equals(getEmail.get(0))
                    && "1111-01-01 00:00".equals(getStartDate) && "9999-12-12 00:00".equals(getEndDate)
                    && 1 == getKeywords.size() && "".equals(getKeywords.get(0))) {
                sortedMails.addAll(emails);
            } else {
                if (!(1 == getEmail.size() && "".equals(getEmail.get(0)))) {
                    emailsFoundByEmail.addAll(contentmentVerification.searchEmailByName(getEmail, emails));
                    if (emailsFoundByEmail.size() > 0) {
                    }
                    emailsFoundByEmailAndDate.addAll(contentmentVerification.searchEmailByDate(getStartDate, getEndDate, emailsFoundByEmail));
                    if (emailsFoundByEmailAndDate.size() > 0) {
                    }
                    sortedMails.addAll(contentmentVerification.searchEmailByTitleWithKeyWords(getKeywords, emailsFoundByEmailAndDate));
                    if (sortedMails.size() > 0) {
                    }
                } else if (!("1111-01-01 00:00".equals(getStartDate) && "9999-12-12 00:00".equals(getEndDate))) {
                    emailsFoundByEmailAndDate.addAll(contentmentVerification.searchEmailByDate(getStartDate, getEndDate, emails));
                    if (emailsFoundByEmailAndDate.size() > 0) {
                    }
                    sortedMails.addAll(contentmentVerification.searchEmailByTitleWithKeyWords(getKeywords, emailsFoundByEmailAndDate));
                    if (sortedMails.size() > 0) {
                    }
                } else if (!(1 == getKeywords.size() && "".equals(getKeywords.get(0)))) {
                    sortedMails.addAll(contentmentVerification.searchEmailByTitleWithKeyWords(getKeywords, emails));
                    if (sortedMails.size() > 0) {
                    }
                }
            }

            return sortedMails;
        }*/
}
