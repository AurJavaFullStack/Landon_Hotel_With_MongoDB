package com.linkedinlearning.reactivespring.controller;

import com.linkedinlearning.reactivespring.model.Reservation;
import com.linkedinlearning.reactivespring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATION)
@CrossOrigin
public class ReservationResource {
        public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";

        private final ReservationService reservationService;

        @Autowired
        public ReservationResource(ReservationService reservationService) {
            this.reservationService = reservationService;
        }


//    @GetMapping(path = "{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//        public Mono<String> getReservationById(@PathVariable String roomId){

        @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public Mono<Reservation> getReservationById(@PathVariable String id){
            //reservationService.getReservation(roomId);
            return reservationService.getReservation(id);//return Mono.just("{}");
        }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<Reservation> getAllReservations(){
        //reservationService.getReservation(roomId);
        return reservationService.listAllReservations();//return Mono.just("{}");
    }

        //public Mono<String> createReservation(@RequestBody Mono<Reservation> reservation){
        @PostMapping(path="",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation){
            return reservationService.createReservation(reservation);//Mono.just("{}");
        }

        @PutMapping(path ="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public Mono<Reservation> updatePrice(@PathVariable String id, @RequestBody Mono<Reservation> reservation){
            return reservationService.updateReservation(id,reservation);//Mono.just("{}");
        }

        @DeleteMapping(path="{id}")
        public Mono<Boolean> deleteReservation(@PathVariable String id){
            return reservationService.deleteReservation(id);//Mono.just(true);
        }
}
