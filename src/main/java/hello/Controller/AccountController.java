package hello.Controller;


import java.util.concurrent.atomic.AtomicLong;

import hello.Model.Account;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class AccountController {

    private final AtomicLong counter = new AtomicLong();
    private final List<Account> accounts = new ArrayList<>();


    @RequestMapping(value = "/listAccounts", method = GET)
    public List<Account> getAccounts() {
        return accounts;
    }

    @RequestMapping(value = "/listAccounts/{id}", method = GET)
    public List<Account> getSelectedAccounts(@PathVariable("id") int id){
        List<Account> results = new ArrayList<>();

        for(int i = 0; i < accounts.size(); i++) {

            if (accounts.get(i).getId() == id)
                results.add(accounts.get(i));
        }



        return results;
    }

    @RequestMapping(value = "/addAccount", method = POST)
    public String addAccount(@RequestBody Account account){

        account.setId((int) counter.incrementAndGet());
        accounts.add(account);

        return "Account added";
    }


    @RequestMapping(value = "/deleteAccount/{id}", method = DELETE)
    public String deleteAccount(@PathVariable("id") int id){

        Account result = null;

        for(int i = 0; i < accounts.size(); i++) {

            if (accounts.get(i).getId() == id)
                result = accounts.get(i);
                accounts.remove(accounts.get(i));
        }


        if(result == null)
            return "The account number:"+ id+ "not founded";
        else
            return "The account number:"+ id + "with user's name:"+result.getName()+" was delete.";

    }

    @RequestMapping(value = "/updateAccount/{id}", method = PUT)
    public String updateAccount(@RequestBody Account account, @PathVariable("id") int id){

        Account result = null;

        for(Account i: accounts){

            if(i.getId() == id){
                change(i,account);
                result = i;
            }

        }

        if(result == null)
            return "The account number:"+ id + "not founded";
        else
            return "The account number:"+ id + "with user's name:"+result.getName()+" was changed.";

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