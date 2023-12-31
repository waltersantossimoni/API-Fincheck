package com.fincheck.apifincheck.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User extends AbstractAuditingEntity {
  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  @Column(unique = true, nullable = false)
  private String email;
  private String password;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<BankAccount> bankAccounts;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Category> categories;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Transaction> transactions;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(bankAccounts, user.bankAccounts) && Objects.equals(categories, user.categories) && Objects.equals(transactions, user.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id, name, email, password, bankAccounts, categories, transactions);
  }
}
