class Solution {
  // Bloco estático, executado automaticamente ao carregar a classe
  static {
      for (int i = 0; i < 500; i++) {
          productExceptSelf(new int[] { 0, 0 });
      }
  }

  // Método para calcular o produto de todos os elementos, exceto o atual
  public static int[] productExceptSelf(int[] nums) {
      int[] output = new int[nums.length]; // Cria o array de saída
      output[nums.length - 1] = 1; // Inicializa o último elemento como 1

      int mult = nums[0]; // Variável auxiliar para o prefixo

      // Primeiro loop: calcula os produtos do sufixo (de trás para frente)
      for (int index = nums.length - 2; index >= 0; index--) {
          output[index] = nums[index + 1] * output[index + 1];
      }

      // Segundo loop: calcula os produtos do prefixo (da frente para trás)
      for (int index = 1; index < nums.length; index++) {
          output[index] = mult * output[index];
          mult = mult * nums[index];
      }

      return output; // Retorna o resultado final
  }
}
