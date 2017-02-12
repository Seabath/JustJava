DELIMITER $$;
DROP FUNCTION IF EXISTS update_user;
CREATE FUNCTION update_user(p_id INT, p_login VARCHAR(20), p_password VARCHAR(20))
  RETURNS INT
  BEGIN
    UPDATE USER SET login = p_login, password = p_password where id = p_id;
    RETURN LAST_INSERT_ID();
  END;