package za.ac.nwu.as.domain.persistance;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Accounts")
public class Account {

  private String id;
  private AccountType accountType;
  private String accountValue;
  private User user;

  @Id
  @Column(name = "Id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "AccountTypeFk")
  public AccountType getAccountTypeFk() {
    return accountType;
  }

  public void setAccountTypeFk(AccountType accountType) {
    this.accountType = accountType;
  }

  @Column(name = "AccountValue")
  public String getAccountValue() {
    return accountValue;
  }

  public void setAccountValue(String accountValue) {
    this.accountValue = accountValue;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "UserFK")
  public User getUserFk() {
    return user;
  }

  public void setUserFk(User user) {this.user = user;}

  @Override
  public String toString() {
    return "Account{" +
            "id='" + id + '\'' +
            ", accountType=" + accountType +
            ", accountValue='" + accountValue + '\'' +
            ", user=" + user +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return Objects.equals(id, account.id) && Objects.equals(accountType, account.accountType) && Objects.equals(accountValue, account.accountValue) && Objects.equals(user, account.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountType, accountValue, user);
  }

  public Account(String id, AccountType accountType, String accountValue, User user) {
    this.id = id;
    this.accountType = accountType;
    this.accountValue = accountValue;
    this.user = user;
  }

  public Account() {
  }
}
