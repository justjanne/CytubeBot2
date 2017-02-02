import de.kuschku.cytubebot2.MyApp;
import de.kuschku.cytubebot2.models.LegacyUser;
import de.kuschku.cytubebot2.models.Message;
import de.kuschku.cytubebot2.models.User;
import de.kuschku.cytubebot2.repositories.LegacyUserRepository;
import de.kuschku.cytubebot2.repositories.MessageRepository;
import de.kuschku.cytubebot2.repositories.UserRepository;
import de.kuschku.cytubebot2.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest(classes = MyApp.class)
@RunWith(SpringRunner.class)
public class UserTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LegacyUserRepository legacyUserRepository;

    @Autowired
    UserService userService;

    @Transactional
    @Before
    public void setUp() {
        /* Legacy User */ {
            User alice = new User();
            alice.setName("alice");
            alice.setRank(1);
            alice.setAward(2);

            LegacyUser aliceLegacy = new LegacyUser();
            aliceLegacy.setFirstActivity(Instant.EPOCH);
            aliceLegacy.setMessageCount(2);
            aliceLegacy.setMessageTotal(5_156_459);

            alice.setLegacyUser(aliceLegacy);
            legacyUserRepository.save(aliceLegacy);
            userRepository.save(alice);

            Message aliceMessage = new Message();
            aliceMessage.setSender(alice);
            aliceMessage.setTimestamp(Instant.now());
            aliceMessage.setContent("this is some text");
            messageRepository.save(aliceMessage);
        }
        /* Normal User */ {
            User bob = new User();
            bob.setName("bob");
            bob.setRank(1);
            bob.setAward(2);
            userRepository.save(bob);

            Message bobMessage = new Message();
            bobMessage.setSender(bob);
            bobMessage.setTimestamp(Instant.now());
            bobMessage.setContent("this is some text");
            messageRepository.save(bobMessage);
        }
    }

    @Transactional
    @After
    public void tearDown() {
        messageRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void testStatsLegacy() {
        String name = "alice";

        Optional<User> byName = userRepository.findByName(name);
        assertTrue(byName.isPresent());

        User user = byName.get();
        Optional<LegacyUser> legacyUserOptional = user.getLegacyUser();
        assertTrue(legacyUserOptional.isPresent());
        LegacyUser legacyUser = legacyUserOptional.get();

        assertNotEquals(userService.messageCount(user), messageRepository.countBySender(user));
        assertNotEquals(userService.messageCount(user), legacyUser.getMessageCount());
        assertNotEquals(userService.messageCount(user), 0);
        assertEquals(userService.messageCount(user), legacyUser.getMessageCount() + messageRepository.countBySender(user));

        assertNotEquals(userService.messageTotal(user), messageRepository.totalBySender(user));
        assertNotEquals(userService.messageTotal(user), legacyUser.getMessageTotal());
        assertNotEquals(userService.messageTotal(user), 0);
        assertEquals(userService.messageTotal(user), legacyUser.getMessageTotal() + messageRepository.totalBySender(user));
    }

    @Test
    public void testStatsExisting() {
        String name = "bob";

        Optional<User> byName = userRepository.findByName(name);
        assertTrue(byName.isPresent());

        User user = byName.get();

        assertFalse(user.getLegacyUser().isPresent());

        assertEquals(userService.messageCount(user), messageRepository.countBySender(user));
        assertNotEquals(userService.messageCount(user), 0);

        assertEquals(userService.messageTotal(user), messageRepository.totalBySender(user));
        assertNotEquals(userService.messageTotal(user), 0);
    }


    @Test
    public void testFirstJoinLegacy() {
        String name = "alice";

        Optional<User> byName = userRepository.findByName(name);
        assertTrue(byName.isPresent());

        User user = byName.get();
        assertEquals(user.getName(), name);

        Optional<Instant> firstJoin = userService.firstActivity(user);
        assertTrue(firstJoin.isPresent());
        assertEquals(firstJoin.get(), Instant.EPOCH);
    }

    @Test
    public void testFirstJoinExisting() {
        String name = "bob";

        Optional<User> byName = userRepository.findByName(name);
        assertTrue(byName.isPresent());

        User user = byName.get();
        assertEquals(user.getName(), name);

        Optional<Instant> firstJoin = userService.firstActivity(user);
        assertTrue(firstJoin.isPresent());
        assertNotEquals(firstJoin.get(), Instant.EPOCH);
    }

    @Test
    public void testNotExisting() {
        String name = "limit";

        Optional<User> byName = userRepository.findByName(name);
        assertFalse(byName.isPresent());
    }
}
