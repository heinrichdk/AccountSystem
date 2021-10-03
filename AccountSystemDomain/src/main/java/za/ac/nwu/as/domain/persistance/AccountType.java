package za.ac.nwu.as.domain.persistance;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="AccountTypes")
public class AccountType {
  @Id
  @Column(name = "Id")
  private String id;
  @Column(name="AccountType")
  private String accountType;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public AccountType() {
  }

  public AccountType(String id, String accountType) {
    this.id = id;
    this.accountType = accountType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccountType that = (AccountType) o;
    return Objects.equals(id, that.id) && Objects.equals(accountType, that.accountType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountType);
  }

  @Override
  public String toString() {
    return "AccountType{" +
            "id='" + id + '\'' +
            ", accountType='" + accountType + '\'' +
            '}';
  }
}
