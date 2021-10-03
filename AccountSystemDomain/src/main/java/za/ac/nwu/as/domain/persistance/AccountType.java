package za.ac.nwu.as.domain.persistance;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="AccountTypes")
public class AccountType {

  private String id;
  private String accountType;
  private Set<Account> account;


  public AccountType() {
  }

  public AccountType(String id, String accountType, Set<Account> account) {
    this.id = id;
    this.accountType = accountType;
    this.account = account;
  }
  @Id
  @Column(name = "Id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Column(name="AccountType")
  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  @OneToMany(targetEntity = Account.class, fetch = FetchType.LAZY, mappedBy = "account", orphanRemoval = true,cascade = CascadeType.PERSIST)
  public Set<Account> getAccount() {
    return account;
  }

  public void setAccount(Set<Account> account) {
    this.account = account;
  }
}
