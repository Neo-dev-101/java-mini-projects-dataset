import java.util.Scanner;

public class RetailSalesAnalyticsSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== MODULE 1: Product-wise Sales (1D Array) =====
        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        int[] productSales = new int[days];
        int total = 0;
        int maxSale = Integer.MIN_VALUE;
        int minSale = Integer.MAX_VALUE;

        System.out.println("Enter daily sales:");
        for (int i = 0; i < days; i++) {
            productSales[i] = sc.nextInt();
            total += productSales[i];
            if (productSales[i] > maxSale) maxSale = productSales[i];
            if (productSales[i] < minSale) minSale = productSales[i];
        }

        double average = (double) total / days;

        System.out.println("\n----- MODULE 1: PRODUCT-WISE SALES ANALYSIS -----");
        System.out.println("Total Sales   : " + total);
        System.out.println("Average Sales : " + average);
        System.out.println("Highest Sale  : " + maxSale);
        System.out.println("Lowest Sale   : " + minSale);

        // ===== MODULE 2: Store-wise Sales (2D Array) =====
        System.out.print("\nEnter number of products: ");
        int products = sc.nextInt();

        System.out.print("Enter number of days for store: ");
        int storeDays = sc.nextInt();

        int[][] storeSales = new int[products][storeDays];
        int[] productTotals = new int[products];
        int bestProductIndex = 0;

        for (int i = 0; i < products; i++) {
            System.out.println("Enter sales for Product " + (i + 1) + ":");
            for (int j = 0; j < storeDays; j++) {
                storeSales[i][j] = sc.nextInt();
                productTotals[i] += storeSales[i][j];
            }
            if (productTotals[i] > productTotals[bestProductIndex]) {
                bestProductIndex = i;
            }
        }

        System.out.println("\n----- MODULE 2: STORE-WISE SALES ANALYSIS -----");
        System.out.println("Product-wise Total Sales:");
        for (int i = 0; i < products; i++) {
            System.out.println("Product " + (i + 1) + ": " + productTotals[i]);
        }
        System.out.println("Best Selling Product: Product " + (bestProductIndex + 1));

        // ===== MODULE 3: Branch-wise Sales (3D Array) =====
        System.out.print("\nEnter number of branches: ");
        int branches = sc.nextInt();

        int[][][] branchSales = new int[branches][products][storeDays];
        int[] branchTotals = new int[branches];
        int topBranchIndex = 0;

        for (int b = 0; b < branches; b++) {
            System.out.println("Enter sales for Branch " + (b + 1) + ":");
            for (int p = 0; p < products; p++) {
                System.out.println("  Product " + (p + 1) + ":");
                for (int d = 0; d < storeDays; d++) {
                    branchSales[b][p][d] = sc.nextInt();
                    branchTotals[b] += branchSales[b][p][d];
                }
            }
            if (branchTotals[b] > branchTotals[topBranchIndex]) {
                topBranchIndex = b;
            }
        }

        System.out.println("\n----- MODULE 3: BRANCH-WISE SALES ANALYSIS -----");
        System.out.println("Branch-wise Total Sales:");
        for (int b = 0; b < branches; b++) {
            System.out.println("Branch " + (b + 1) + ": " + branchTotals[b]);
        }
        System.out.println("Top Performing Branch: Branch " + (topBranchIndex + 1));

        System.out.println("\n----- RETAIL SALES ANALYTICS COMPLETED -----");

        sc.close();
    }
}