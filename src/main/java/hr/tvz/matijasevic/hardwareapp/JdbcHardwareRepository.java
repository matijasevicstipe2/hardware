package hr.tvz.matijasevic.hardwareapp;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class JdbcHardwareRepository implements HardwareRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insert;

    public JdbcHardwareRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("hardwares")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Hardware> findAll() {
        return jdbcTemplate.query("SELECT * from hardwares",this::mapRowToHardware);
    }
    @Override
    public List<Hardware> findAllWithString(String string) {
        return jdbcTemplate
                .query("SELECT * from hardwares where LOWER(name) like '%"+ string.toLowerCase() +"%'",
                        this::mapRowToHardware);

    }



    @Override
    public Optional<Hardware> findByCode(String code) {
        return
                Optional.ofNullable(jdbcTemplate
                        .queryForObject("Select * from hardwares where code = ?",this::mapRowToHardware,code));
    }

    @Override
    public Optional<Hardware> save(HardwareCommand command) {
        command.setId(saveHardwareDetails(command));
        Hardware hardware =
                new Hardware(command.getId(),command.getName(),
                        command.getCode(),command.getPrice(),command.getType(),command.getCount());
        return Optional.of(hardware);
    }

    @Override
    public int deleteByCode(String code) {
        jdbcTemplate.update("DELETE FROM reviews WHERE reviews.hardware_id IN " +
                "(SELECT hardwares.id FROM hardwares where code = ?)",code);
        return jdbcTemplate.update("delete from hardwares where code = ?",code);
    }
    private Hardware mapRowToHardware(ResultSet rs, int num) throws SQLException {
        return new Hardware(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("code"),
                rs.getInt("price"),
                TypeEnum.valueOf(rs.getString("type")),
                rs.getInt("count"));
    }

    private long saveHardwareDetails(HardwareCommand hardware){
        Map<String,Object> values = new HashMap<>();
        values.put("name",hardware.getName());
        values.put("code",hardware.getCode());
        values.put("price",hardware.getPrice());
        values.put("type",hardware.getType().toString());
        values.put("count",hardware.getCount());

        return insert.executeAndReturnKey(values).longValue();
    }
}
