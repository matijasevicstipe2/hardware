package hr.tvz.matijasevic.hardwareapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
public class HardwareController implements Serializable {


    private HardwareService hardwareService;
    public HardwareController(HardwareService hardwareService){
        this.hardwareService = hardwareService;
    }

    @GetMapping("all/{string}")
    public List<HardwareDTO> getAllHardwareWithString(@PathVariable String string){
        return hardwareService.findAllWithString(string);
    }

    @GetMapping()
    public List<HardwareDTO> getAllHardware(){
        return hardwareService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<HardwareDTO> getHardwareByCode(@PathVariable String code){
        System.out.println("pi");
        return hardwareService.findByCode(code)
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<HardwareDTO> createHardware(@Valid @RequestBody final HardwareCommand command){

        return hardwareService.save(command)
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
   /* @PutMapping("/{code}")
    public ResponseEntity<HardwareDTO> update(@PathVariable String code, @Valid @RequestBody
    final HardwareCommand hardwareCommand){
        return hardwareService.update(code,hardwareCommand)
                .map(ResponseEntity.ok())
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }*/

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured({"ROLE_ADMIN","ROLE_DELETER"})
    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code){
        hardwareService.deleteByCode(code);
    }


}
