import groovy.util.GroovyTestCase
/**
 * Created by markwagner on 2/19/15.
 */
class BankAccountTests extends GroovyTestCase {

    private account

    def void setUp(){
        account = new BankAccount(10)
    }
    
    def void tearDown(){
        account = null
    }

    def void testCanDepositMoney(){
        account.deposit(5)
        assert 15 == account.balance
    }

    def void testCanWithdrawMoney(){
        account.withdraw(5)
        assert 5 == account.balance
    }

}
