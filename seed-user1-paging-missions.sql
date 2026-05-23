DROP PROCEDURE IF EXISTS seed_user1_paging_missions;

DELIMITER //

CREATE PROCEDURE seed_user1_paging_missions()
BEGIN
    DECLARE existing_count INT DEFAULT 0;
    DECLARE target_count INT DEFAULT 100;
    DECLARE rows_to_add INT DEFAULT 0;
    DECLARE i INT DEFAULT 1;
    DECLARE next_user_mission_id BIGINT DEFAULT 1;
    DECLARE new_mission_id BIGINT;

    SELECT COUNT(*)
    INTO existing_count
    FROM `user_mission`
    WHERE `user_id` = 1;

    SET rows_to_add = GREATEST(target_count - existing_count, 0);

    SELECT COALESCE(MAX(`id`), 0) + 1
    INTO next_user_mission_id
    FROM `user_mission`;

    WHILE i <= rows_to_add DO
        INSERT INTO `mission` (`min_order_amount`, `reward`, `id_restaurant`)
        VALUES (
            10000 + (i * 100),
            500 + (MOD(i, 10) * 100),
            MOD(i - 1, 3) + 1
        );

        SET new_mission_id = LAST_INSERT_ID();

        INSERT INTO `user_mission` (`id`, `mission_id`, `user_id`, `completed`)
        VALUES (
            next_user_mission_id,
            new_mission_id,
            1,
            MOD(i, 2) = 0
        );

        SET next_user_mission_id = next_user_mission_id + 1;
        SET i = i + 1;
    END WHILE;

    UPDATE `user_mission_seq`
    SET `next_val` = GREATEST(`next_val`, next_user_mission_id);
END //

DELIMITER ;

CALL seed_user1_paging_missions();

DROP PROCEDURE seed_user1_paging_missions;
