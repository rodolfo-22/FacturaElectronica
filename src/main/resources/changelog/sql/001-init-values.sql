-- liquibase formatted sql

-- changeset gabriel:1762536569870-7
CREATE TABLE roles
(
    id          UUID NOT NULL,
    role        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

-- changeset gabriel:1762536569870-3
CREATE TABLE employees
(
    id       UUID NOT NULL,
    name     VARCHAR(255),
    surname  VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    address  VARCHAR(255),
    phone    VARCHAR(255),
    roles_id UUID,
    CONSTRAINT pk_employees PRIMARY KEY (id)
);

-- changeset gabriel:1762536569870-1
CREATE TABLE categories
(
    id            UUID NOT NULL,
    category_name VARCHAR(255),
    description   VARCHAR(255),
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

-- changeset gabriel:1762536569870-2
CREATE TABLE customers
(
    id      UUID NOT NULL,
    name    VARCHAR(255),
    surname VARCHAR(255),
    email   VARCHAR(255),
    address VARCHAR(255),
    phone   VARCHAR(255),
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

-- changeset gabriel:1762536569870-6
CREATE TABLE qrcodes
(
    id     UUID    NOT NULL,
    time   TIMESTAMP WITHOUT TIME ZONE,
    active BOOLEAN NOT NULL,
    code   VARCHAR(255),
    CONSTRAINT pk_qrcodes PRIMARY KEY (id)
);

-- changeset gabriel:1762536569870-4
CREATE TABLE information_company
(
    id           UUID NOT NULL,
    company_name VARCHAR(255),
    address      VARCHAR(255),
    phone        VARCHAR(255),
    email        VARCHAR(255),
    tax_id       VARCHAR(255),
    nit          VARCHAR(255),
    CONSTRAINT pk_informationcompany PRIMARY KEY (id)
);

-- changeset gabriel:1762536569870-5
CREATE TABLE products
(
    id             UUID             NOT NULL,
    product_name   VARCHAR(255),
    product_number VARCHAR(255),
    color          VARCHAR(255),
    price          DOUBLE PRECISION NOT NULL,
    stock          INTEGER          NOT NULL,
    size           VARCHAR(255),
    weight         VARCHAR(255),
    model          VARCHAR(255),
    description    VARCHAR(255),
    image_url      VARCHAR(255),
    categories_id  UUID,
    CONSTRAINT pk_products PRIMARY KEY (id)
);


-- changeset gabriel:1762536569870-8
CREATE TABLE sales
(
    id                  UUID             NOT NULL,
    total_price         DOUBLE PRECISION NOT NULL,
    sale_date           VARCHAR(255),
    account_tags        VARCHAR(255),
    operation_condition VARCHAR(255),
    types_of_payment    VARCHAR(255),
    pament_installments VARCHAR(255),
    treasury_date       TIMESTAMP WITHOUT TIME ZONE,
    payment_due_date    TIMESTAMP WITHOUT TIME ZONE,
    comercial_name      VARCHAR(255),
    sales_team          VARCHAR(255),
    journal_entry       VARCHAR(255),
    proyect             VARCHAR(255),
    description         VARCHAR(255),
    employee_id         UUID,
    customer_id         UUID,
    qr_code_id          UUID,
    CONSTRAINT pk_sales PRIMARY KEY (id)
);

-- changeset gabriel:1762536569870-9
CREATE TABLE sales_details
(
    id          UUID             NOT NULL,
    quantity    INTEGER          NOT NULL,
    total_price DOUBLE PRECISION NOT NULL,
    sales_id    UUID,
    products_id UUID,
    CONSTRAINT pk_salesdetails PRIMARY KEY (id)
);

-- changeset gabriel:1762536569870-10
ALTER TABLE sales
    ADD CONSTRAINT uc_sales_qr_code UNIQUE (qr_code_id);

-- changeset gabriel:1762536569870-11
ALTER TABLE employees
    ADD CONSTRAINT FK_EMPLOYEES_ON_ROLES FOREIGN KEY (roles_id) REFERENCES roles (id);

-- changeset gabriel:1762536569870-12
ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORIES FOREIGN KEY (categories_id) REFERENCES categories (id);

-- changeset gabriel:1762536569870-13
ALTER TABLE sales_details
    ADD CONSTRAINT FK_SALESDETAILS_ON_PRODUCTS FOREIGN KEY (products_id) REFERENCES products (id);

-- changeset gabriel:1762536569870-14
ALTER TABLE sales_details
    ADD CONSTRAINT FK_SALESDETAILS_ON_SALES FOREIGN KEY (sales_id) REFERENCES sales (id);

-- changeset gabriel:1762536569870-15
ALTER TABLE sales
    ADD CONSTRAINT FK_SALES_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);

-- changeset gabriel:1762536569870-16
ALTER TABLE sales
    ADD CONSTRAINT FK_SALES_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (id);

-- changeset gabriel:1762536569870-17
ALTER TABLE sales
    ADD CONSTRAINT FK_SALES_ON_QR_CODE FOREIGN KEY (qr_code_id) REFERENCES qrcodes (id);

