package za.ac.nwu.as.domain.dto;

import io.swagger.annotations.ApiModel;

import java.util.Objects;

@ApiModel(value = "Account", description="A DTO that represents an account of an user")
public class AccountDto {

    private String Id;
    private String AccountTypeName;
    private Double Value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(Id, that.Id) && Objects.equals(AccountTypeName, that.AccountTypeName) && Objects.equals(Value, that.Value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, AccountTypeName, Value);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "Id='" + Id + '\'' +
                ", AccountTypeName='" + AccountTypeName + '\'' +
                ", Value=" + Value +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAccountTypeName() {
        return AccountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        AccountTypeName = accountTypeName;
    }

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }

public AccountDto(String id, String accountTypeName, Double value) {
        Id = id;
        AccountTypeName = accountTypeName;
        Value = value;
    }

    public AccountDto() {
    }
}
