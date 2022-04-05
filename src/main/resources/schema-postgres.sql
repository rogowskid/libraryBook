CREATE TABLE IF NOT EXISTS User_Data(
    id_User INT  AUTO_INCREMENT,
    user_Login varchar(20) NOT NULL,
    user_Password varchar(100)  NOT NULL,
    name_User varchar(100)  NOT NULL,
    sur_Name_User varchar(100)  NOT NULL,
    date_Of_Birthday DATE  NOT NULL,
    id_Role int(2),
    FOREIGN KEY (id_Role) REFERENCES role_User(id_Role),
    PRIMARY KEY (id_User)
    );



CREATE TABLE IF NOT EXISTS Book(
    id_Book int  AUTO_INCREMENT,
    name_Book varchar(100) NOT NULL,
    author varchar(100) NOT NULL,
    year_Of_Publication INT(4) NOT NULL,
    ISBN varchar(100) NOT NULL,
    PRIMARY KEY (id_Book)
);




CREATE TABLE IF NOT EXISTS recent_Book(

    id_Recent int(11) AUTO_INCREMENT ,
    id_User int (11) NOT NULL,
    id_Book int(11) NOT NULL,
    date_Of_Return DATE NOT NULL,

    PRIMARY KEY (id_Recent),
    FOREIGN KEY (id_User) REFERENCES User_Data(id_User),
    FOREIGN KEY (id_Book) REFERENCES Book(id_Book)

    );

CREATE TABLE IF NOT EXISTS role_User(

    id_Role int(2) AUTO_INCREMENT,
    nameRole varchar(100) not null,

    primary key (id_Role)

);
