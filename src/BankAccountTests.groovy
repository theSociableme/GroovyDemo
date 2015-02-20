import groovy.util.GroovyTestCase
import groovy.mock.interceptor.*

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

    def void testCanNotWithdrawMoreMoneyThanBalance(){
        shouldFail(InsufficientFundsException) {
            account.withdraw(15)
        }
    }

    //StubFor
    def void testCanAccrueInterest(){
        def service = new StubFor(InterestRateService)
        service.demand.getInterestRate {
            return 0.10
        }
        service.use {
            account.accrueInterest()
            assert 11 == account.balance
        }
    }

    //MockFor
    def void testCanAccrueInterestWithVerificationOfService(){
        def service = new MockFor(InterestRateService)
        service.demand.getInterestRate {
            return 0.10
        }
        service.use {
            account.accrueInterest()
            assert 11 == account.balance
        }
    }
}
