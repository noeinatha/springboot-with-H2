package com.example.demoDatabase.service;

import com.example.demoDatabase.exception.UserNotFoundException;
import com.example.demoDatabase.model.Account;
import com.example.demoDatabase.model.User;
import com.example.demoDatabase.repository.AccountRepository;
import com.example.demoDatabase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;


    public List<Account> getUserAccounts(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public Account createAccount(Account account) {
        // Check if the user exists
        User user = userRepository.findById(account.getUserId()).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return accountRepository.save(account);
    }

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public Account updateAccountDetails(Long accountId, Account updatedAccount) {
        Account existingAccount = accountRepository.findById(accountId).orElse(null);
        if (existingAccount != null) {
            // Update account details as needed (e.g., balance, account type, etc.)
            existingAccount.setBalance(updatedAccount.getBalance());
            // You can add more update logic here
            return accountRepository.save(existingAccount);
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}