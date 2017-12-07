package fb;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

public class AccountsMergeTest {
    @Test
    public void test() {
        List<List<String>> accounts = ImmutableList.of(
                ImmutableList.of("John", "johnsmith@mail.com", "john00@mail.com"),
                ImmutableList.of("John", "johnnybravo@mail.com"),
                ImmutableList.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                ImmutableList.of("Mary", "mary@mail.com"));
        AccountsMerge test = new AccountsMerge();
        List<List<String>> res = test.accountsMerge(accounts);
    }

    @Test
    public void test2() {
        // [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
        List<List<String>> accounts = ImmutableList.of(ImmutableList.of("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
        AccountsMerge test = new AccountsMerge();
        List<List<String>> res = test.accountsMerge(accounts);
    }
}
