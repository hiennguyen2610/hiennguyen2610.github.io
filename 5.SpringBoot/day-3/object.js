function Product(product_name, product_price, product_brand, product_count) {
  this.name = product_name
  this.price = product_price
  this.brand = product_brand
  this.count = product_count
}

const product1 = new Product("Iphone 13 Pro Max", 30000000, "Apple", 2)
const product2 = new Product("Galaxy Z Fold3", 41000000, "Samsung", 1)
const product3 = new Product("Iphone 11", 15500000, "Apple", 1)
const product4 = new Product("OPPO Find X3 Pro", 19500000, "OPPO", 3)

function print_product_list(product_arr) {
  for (product of product_arr)
    console.log(
      `     ${product.name}  -  ${product.price}  -  ${product.brand}  -  ${product.count}`
    )
}

let products = [product1, product2, product3, product4]

// Bai 1.
console.log("1. List Products: ")
print_product_list(products)

// Bai 2. (reduce)
function total_price(product_list) {
  return product_list.reduce((totalPrice, currentValue) => {
    return totalPrice + currentValue.price * currentValue.count
  }, 0)
}
const total = total_price(products)
console.log("2. Total price: ", total)

// Bai 3
function filter_by_brand(product_list, brand) {
  return product_list.filter((product) => product.brand === brand)
}
const apple_products = filter_by_brand(products, "Apple")
console.log("3. Apple Products: ")
print_product_list(apple_products)

// Bai 4
function filter_by_price(product_list, price) {
  return product_list.filter((product) => product.price >= price)
}
const min_price_20000000 = filter_by_price(products, 20000000)
console.log("4. Sản phẩm có giá lớn hơn 20000000: ")
print_product_list(min_price_20000000)

// Bai 5
function filter_by_name(product_list, subStr){
	return product_list.filter(product => product.name.toLowerCase().includes(subStr))
}
console.log("5. Sản phẩm có chữ Pro: ")
print_product_list(filter_by_name(products, "pro"))

// Bai 6
function add_element(product_list, product_item){
    return 
}
// Bai 7
// Bai 8 (sort)
// Bai 9 (sort)
// Bai 10
//1404936