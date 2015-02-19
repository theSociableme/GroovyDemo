/**
 * Created by markwagner on 2/19/15.
 */
class BankAccount {
    private balance

    BankAccount(openingBalance){
        balance = openingBalance
    }

    def void deposit(amount){
        balance += amount
    }
}
