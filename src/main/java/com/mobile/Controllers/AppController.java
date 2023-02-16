package com.mobile.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.DTO.ResponseData;
import com.mobile.DTO.UserData;
import com.mobile.Modals.Entities.Appuser;
import com.mobile.Services.AppUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AppController {

  @Autowired
  private AppUserService appUserService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping
  public Iterable<Appuser> login() {
    return appUserService.getAllAppusers();
  }

  @PostMapping("/register")
  public ResponseEntity<ResponseData<Appuser>> register(
    @Valid @RequestBody UserData userData,
    Errors errors
  ) {
    ResponseData<Appuser> responseData = new ResponseData<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    Appuser appuser = modelMapper.map(userData, Appuser.class);

    responseData.setPayload(appUserService.registerAppuser(appuser));
    responseData.setStatus(true);
    return ResponseEntity.ok(responseData);
  }
}
