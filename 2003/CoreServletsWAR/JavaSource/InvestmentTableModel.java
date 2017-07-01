import java.text.NumberFormat;

import javax.swing.table.AbstractTableModel;

/** 
   This table model computes the cell entries each time they
   are requested. The table contents shows the growth of
   an investment for a number of years under different interest
   rates.
*/
class InvestmentTableModel extends AbstractTableModel
{  
   /**
	  Constructs an investment table model.
	  @param y the number of years
	  @param r1 the lowest interest rate to tabulate
	  @param r2 the highest interest rate to tabulate
   */
   public InvestmentTableModel(int y, int r1, int r2)
   {  
	  years = y;
	  minRate = r1;
	  maxRate = r2;
   }

   public int getRowCount()
   {  
	  return years;
   }

   public int getColumnCount()
   {  
	  return maxRate - minRate + 1;
   }

   public Object getValueAt(int r, int c)
   {  
	  double rate = (c + minRate) / 100.0;
	  int nperiods = r;

	  double futureBalance = INITIAL_BALANCE
		 * Math.pow(1 + rate, nperiods);

	  return
		 NumberFormat.getCurrencyInstance().format(futureBalance);
   }

   public String getColumnName(int c)
   {  
	  double rate = (c + minRate) / 100.0;
	  return
		 NumberFormat.getPercentInstance().format(rate);
   }

   private int years;
   private int minRate;
   private int maxRate;

   private static double INITIAL_BALANCE = 100000.0;
}
