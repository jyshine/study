from selenium import webdriver
import time
options = webdriver.ChromeOptions()
options.add_argument("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
driver = webdriver.Chrome("../chromedriver", options=options)
driver.get("https://world.taobao.com/?spm=a1z0d.6639537.0.0.7a517484J4TVgF")

driver.find_element_by_class_name("searchbar-input").send_keys('遮阳伞')
driver.find_element_by_class_name("search-button-text").click()
driver.find_element_by_id('fm-login-id').send_keys("jyshine3@gmail.com")
driver.find_element_by_id('fm-login-password').send_keys('commerce3#')
driver.find_element_by_class_name('fm-submit').click()
