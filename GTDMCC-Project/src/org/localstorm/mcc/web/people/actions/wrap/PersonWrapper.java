package org.localstorm.mcc.web.people.actions.wrap;

import java.util.Date;

import org.localstorm.mcc.ejb.people.Person;
import org.localstorm.mcc.ejb.people.PersonGroup;

/**
 *
 * @author Alexey Kuznetsov
 */
public class PersonWrapper extends Person
{
    private Person person;
    private PersonGroup group;

    public PersonWrapper(Person person, PersonGroup group) {
        this.person = person;
        this.group  = group;
    }

    @Override
    public Integer getId() {
        return this.person.getId();
    }

    @Override
    public Date getBirthDate()
    {
        return person.getBirthDate();
    }

    @Override
    public String getFullName()
    {
        return person.getFullName();
    }

    @Override
    public String getLastName()
    {
        return person.getLastName();
    }

    @Override
    public String getName()
    {
        return person.getName();
    }

    @Override
    public String getPatronymicName()
    {
        return person.getPatronymicName();
    }

    @Override
    public String getShortName()
    {
        return person.getShortName();
    }

    @Override
    public void setBirthDate(Date birthDate)
    {
        person.setBirthDate(birthDate);
    }

    @Override
    public void setPatronymicName(String pName)
    {
        person.setPatronymicName(pName);
    }

    @Override
    public void setLastName(String lastName)
    {
        person.setLastName(lastName);
    }

    @Override
    public void setName(String name)
    {
        person.setName(name);
    }

    public PersonGroup getGroup()
    {
        return group;
    }
}