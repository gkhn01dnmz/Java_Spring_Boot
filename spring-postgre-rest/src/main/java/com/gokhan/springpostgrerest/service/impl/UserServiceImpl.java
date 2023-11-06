package com.gokhan.springpostgrerest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.bridge.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.gokhan.springpostgrerest.dto.UserDto;
import com.gokhan.springpostgrerest.entities.Address;
import com.gokhan.springpostgrerest.entities.User;
import com.gokhan.springpostgrerest.repos.AddressRepository;
import com.gokhan.springpostgrerest.repos.UserRepository;
import com.gokhan.springpostgrerest.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto){
       Assert.notNull (userDto.getName(),"Adi alanı zorunludur");
        User user=new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userdb= userRepository.save(user);
        List<Address> liste=new ArrayList<>();

        userDto.getAddresses().forEach(item ->{
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setUser(userdb);
            liste.add(address);
        });
            addressRepository.saveAll(liste);
            userDto.setId(userdb.getId());
            return userDto;
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }



    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users= userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<UserDto>();

       users.forEach(it->{
        UserDto userDto = new UserDto();
        userDto.setId(it.getId());
        userDto.setName(it.getName());
        userDto.setSurname(it.getSurname());
        userDto.setAddresses(it.getAddresses().stream().map(Address::getAddress)
                .collect(Collectors.toList()));
        
                userDtoList.add(userDto);
       });
       return userDtoList;
    }



}
