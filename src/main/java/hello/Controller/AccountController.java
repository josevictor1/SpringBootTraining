package hello.Controller;


import java.util.concurrent.atomic.AtomicLong;

import hello.Model.Account;
import hello.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping(value = "accounts/")
public class AccountController {

    private final AtomicLong counter = new AtomicLong();


    @Autowired
    private AccountRepository accountrepository;

    @RequestMapping(value = "/listAccounts", method = GET)
    public List<Account> getAccounts() {
        return (List<Account>) accountrepository.findAll();
    }

    @RequestMapping(value = "/listAccounts/{id}", method = GET)
    public Account getSelectedAccounts(@PathVariable("id") int id){
        List<Account> accounts = (List<Account>) accountrepository.findAll();

        for (Account i: accounts){
            if(i.getId() == id){
                return i;
            }
        }



        return null;
    }

    @RequestMapping(value = "/addAccount", method = POST)
    public String addAccount(@RequestBody Account account, BindingResult result){

        account.setId((int) counter.incrementAndGet());
        if (result.hasErrors()) {
            return "error";
        }

        accountrepository.save(account);

        return "Salvo com sucesso!";
    }


    @RequestMapping(value = "/deleteAccount/{id}", method = DELETE)
    public String deleteAccount(@PathVariable("id") int id){

        Account result = accountrepository.findById(id);




        if(result == null) {
            return "The account number:" + id + "not founded";
        }
        else {
            accountrepository.delete(result);
            return "The account number:" + id + "with user's name:" + result.getName() + " was delete.";
        }
    }

    @RequestMapping(value = "/updateAccount/{id}", method = PUT)
    public String updateAccount(@RequestBody Account account, @PathVariable("id") int id){

        Account result = accountrepository.findById(id);



        if(result == null) {
            return "The account number:" + id + "not founded";
        }
        else {
            change(result, account);
            accountrepository.save(account);
            return "The account number:" + id + "with user's name:" + result.getName() + " was changed.";

        }

    }

    public void change(Account original, Account changed){

        if (changed.getId() != -1){
            original.setId(changed.getId());
        }
        if (changed.getDescription() != null){
            original.setDescription(changed.getDescription());
        }
        if(original.getName() != null){
            original.setName(changed.getName());
        }

    }


}