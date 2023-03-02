import pymysql

# 连接数据库
conn = pymysql.connect(host='sh-cynosdbmysql-grp-oo5964xk.sql.tencentcdb.com',port= 27647, user='root', password='Zryuestc261825', db='bill_alll')

# 创建Account表
create_account_table_sql = '''
CREATE TABLE Account (
    account_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    registration_time DATETIME NOT NULL,
    last_login_time DATETIME,
    last_login_devices TEXT,
    last_login_ip_addresses TEXT,
    email VARCHAR(255),
    phone_number VARCHAR(255),
    nickname VARCHAR(255),
    PRIMARY KEY (account_id)
)
'''
with conn.cursor() as cursor:
    cursor.execute(create_account_table_sql)

# 创建Transaction表
create_transaction_table_sql = '''
CREATE TABLE Transaction (
    transaction_id INT NOT NULL AUTO_INCREMENT,
    account_id INT NOT NULL,
    transaction_date DATE NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    category VARCHAR(255),
    description VARCHAR(255),
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
)
'''
with conn.cursor() as cursor:
    cursor.execute(create_transaction_table_sql)

# 插入示例数据
insert_account_sql = '''
INSERT INTO Account (username, password_hash, registration_time, email, phone_number, nickname)
VALUES
    ('user1', 'hash1', '2022-01-01 00:00:00', 'user1@example.com', '123456789', 'Alice'),
    ('user2', 'hash2', '2022-01-02 00:00:00', 'user2@example.com', '987654321', 'Bob'),
    ('user3', 'hash3', '2022-01-03 00:00:00', 'user3@example.com', '555555555', 'Charlie'),
    ('user4', 'hash4', '2022-01-04 00:00:00', 'user4@example.com', '666666666', 'David')
'''
with conn.cursor() as cursor:
    cursor.execute(insert_account_sql)

insert_transaction_sql = '''
INSERT INTO Transaction (account_id, transaction_date, amount, category, description)
VALUES
    (1, '2022-01-01', 100.00, 'food', 'lunch'),
    (1, '2022-01-01', 20.00, 'shopping', 'clothes'),
    (2, '2022-01-02', 50.00, 'entertainment', 'movie'),
    (3, '2022-01-03', 200.00, 'transportation', 'train'),
    (4, '2022-01-04', 80.00, 'food', 'dinner')
'''
with conn.cursor() as cursor:
    cursor.execute(insert_transaction_sql)

# 提交更改并关闭连接
conn.commit()
conn.close()
