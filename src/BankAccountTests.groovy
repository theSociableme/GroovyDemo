import groovy.util.GroovyTestCase
/**
 * Created by markwagner on 2/19/15.
 */
class BankAccountTests extends GroovyTestCase {

    def void testCanDepositMoney(){
        def account = new BankAccount(10)
        account.deposit(5)
        assert 15 == account.balance
    }
    
}
